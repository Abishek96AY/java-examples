package com.examples.inheritance;

/*
 * Java does not support multiple inheritance with classes directly due to the "Diamond Problem," where 
 * ambiguity arises if two super classes have methods with the same signature. However, it's achievable 
 * through interfaces because they only contain method signatures, not implementations.
 */

interface Animal4 {
    void eat();
    void sleep();
}

interface Pet {
    void play();
}

class Dog implements Animal4, Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // Output: Dog is eating
        dog.sleep(); // Output: Dog is sleeping
        dog.play(); // Output: Dog is playing
    }
}