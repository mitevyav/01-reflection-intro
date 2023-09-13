package com.basicsstrong.reflection;

import java.lang.reflect.Constructor;

class MyClass {
    private MyClass() {
        System.out.println("MyClass Object Created");
    }
}


public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // MyClass obj = new MyClass(); // Normal way of creating Object

        // Reflection way of creating Object
        Class<?> classObject = Class.forName("com.basicsstrong.reflection.MyClass");
        Constructor<?> constructorObject = classObject.getDeclaredConstructor();
        constructorObject.setAccessible(true); // To access private constructor
        MyClass myClass = (MyClass) constructorObject.newInstance();
    }
}