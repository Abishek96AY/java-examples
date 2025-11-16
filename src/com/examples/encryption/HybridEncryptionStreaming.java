package com.examples.encryption;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class HybridEncryptionStreaming {

    // ===== Global Configurations =====
    private static final String INPUT_FILE = "/home/abisheks@offaurusinc.com/Downloads/large_input.txt";
    private static final String ENCRYPTED_FILE = "/home/abisheks@offaurusinc.com/Downloads/encrypted_file.hyenc"; 
    private static final String DECRYPTED_FILE = "/home/abisheks@offaurusinc.com/Downloads/decrypted_large_file.txt";
    private static final String ENCRYPTED_AES_KEY_FILE = "/home/abisheks@offaurusinc.com/Downloads/encrypted_aes_key.hyenc";
    private static final String AES_IV_FILE = "/home/abisheks@offaurusinc.com/Downloads/aes_iv.hyenc";
    private static final String RSA_PUBLIC_KEY_FILE = "/home/abisheks@offaurusinc.com/Downloads/rsa_public.key";
    private static final String RSA_PRIVATE_KEY_FILE = "/home/abisheks@offaurusinc.com/Downloads/rsa_private.key";

    // ===== Encryption Constants =====
    private static final int AES_KEY_SIZE = 256;      // bits
    private static final int GCM_IV_LENGTH = 12;      // bytes
    private static final int GCM_TAG_LENGTH = 128;    // bits
    private static final int RSA_KEY_SIZE = 4096;     // bits

    public static void main(String[] args) throws Exception {

        KeyPair rsaKeyPair;

        // Check if RSA keys already exist
        if (Files.exists(Paths.get(RSA_PUBLIC_KEY_FILE)) && Files.exists(Paths.get(RSA_PRIVATE_KEY_FILE))) {
            System.out.println("🔑 Loading existing RSA keys...");
            rsaKeyPair = loadRSAKeyPair(RSA_PUBLIC_KEY_FILE, RSA_PRIVATE_KEY_FILE);
        } else {
            System.out.println("🔑 Generating new RSA keys...");
            rsaKeyPair = generateRSAKeyPair();
            saveRSAKeyPair(rsaKeyPair, RSA_PUBLIC_KEY_FILE, RSA_PRIVATE_KEY_FILE);
        }

        PublicKey publicKey = rsaKeyPair.getPublic();
        PrivateKey privateKey = rsaKeyPair.getPrivate();

        // Generate AES key and IV
        SecretKey aesKey = generateAESKey();
        byte[] iv = generateIV();

        // Encrypt large file
        encryptFileAES(INPUT_FILE, ENCRYPTED_FILE, aesKey, iv);

        // Encrypt AES key with RSA public key
        byte[] encryptedAesKey = encryptAESKeyWithRSA(aesKey, publicKey);
        writeFile(ENCRYPTED_AES_KEY_FILE, encryptedAesKey);
        writeFile(AES_IV_FILE, iv);

        System.out.println("✅ Encryption complete!");
        System.out.println(" - Encrypted data: " + ENCRYPTED_FILE);
        System.out.println(" - Encrypted AES key: " + ENCRYPTED_AES_KEY_FILE);
        System.out.println(" - IV: " + AES_IV_FILE);

        // Decrypt AES key with RSA private key
        SecretKey decryptedAesKey = decryptAESKeyWithRSA(encryptedAesKey, privateKey);

        // Decrypt large file
        decryptFileAES(ENCRYPTED_FILE, DECRYPTED_FILE, decryptedAesKey, iv);

        System.out.println("✅ Decryption complete!");
        System.out.println(" - Decrypted file: " + DECRYPTED_FILE);
    }

    // ----- AES Key Generation -----
    private static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(AES_KEY_SIZE);
        return keyGen.generateKey();
    }

    // ----- RSA Key Pair Generation -----
    private static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(RSA_KEY_SIZE);
        return keyGen.generateKeyPair();
    }

    // ----- Save RSA Key Pair to files -----
    private static void saveRSAKeyPair(KeyPair keyPair, String pubFile, String privFile) throws Exception {
        writeFile(pubFile, keyPair.getPublic().getEncoded());
        writeFile(privFile, keyPair.getPrivate().getEncoded());
        System.out.println("💾 RSA keys saved: " + pubFile + ", " + privFile);
    }

    // ----- Load RSA Key Pair from files -----
    private static KeyPair loadRSAKeyPair(String pubFile, String privFile) throws Exception {
        byte[] pubBytes = Files.readAllBytes(Paths.get(pubFile));
        byte[] privBytes = Files.readAllBytes(Paths.get(privFile));

        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pubKey = kf.generatePublic(new X509EncodedKeySpec(pubBytes));
        PrivateKey privKey = kf.generatePrivate(new PKCS8EncodedKeySpec(privBytes));
        return new KeyPair(pubKey, privKey);
    }

    // ----- AES File Encryption (Streaming) -----
    private static void encryptFileAES(String inputFile, String outputFile, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_LENGTH, iv));
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) cos.write(buffer, 0, bytesRead);
        }
    }

    // ----- AES File Decryption (Streaming) -----
    private static void decryptFileAES(String inputFile, String outputFile, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_LENGTH, iv));
        try (FileInputStream fis = new FileInputStream(inputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) fos.write(buffer, 0, bytesRead);
        }
    }

    // ----- RSA Encrypt AES Key -----
    private static byte[] encryptAESKeyWithRSA(SecretKey aesKey, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(aesKey.getEncoded());
    }

    // ----- RSA Decrypt AES Key -----
    private static SecretKey decryptAESKeyWithRSA(byte[] encryptedKey, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] keyBytes = cipher.doFinal(encryptedKey);
        return new SecretKeySpec(keyBytes, "AES");
    }

    // ----- Generate random IV -----
    private static byte[] generateIV() {
        byte[] iv = new byte[GCM_IV_LENGTH];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    // ----- Utility: Write byte array to file -----
    private static void writeFile(String filename, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(data);
        }
    }
}