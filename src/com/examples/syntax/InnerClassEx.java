package com.examples.syntax;

class Class {
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

class InnerClassEx extends Class {
    public static void main(String[] args) {
    	Class obj = new Class();
        InnerClass inner = obj.new InnerClass();
        inner.callEat();
        obj.sleep();
    }
}
