package com.examples.others;

class Class1 {
    private void eat() {
        System.err.println("Eat !!!");
    }

    public void sleep() {
        System.err.println("Sleep !!!");
    }

    class InnerClass {
        public void callEat() {
            eat();  // Can call the private method
        }
    }
}

class InnerClassEx extends Class1 {
    public static void main(String[] args) {
        Class1 obj = new Class1();
        Class1.InnerClass inner = obj.new InnerClass();
        inner.callEat();
        obj.sleep();
    }
}
