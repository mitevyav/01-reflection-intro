package com.basicsstrong.reflection;

interface MyInterface {
}

interface AnotherInterface {
}

class TestSuperClass {
}

class TestClass extends TestSuperClass implements MyInterface, AnotherInterface {
}

public class GettingClassObject {

    public static void main(String[] args) throws ClassNotFoundException {
        // forName
        Class<?> classObject1 = Class.forName("java.lang.String");
        Class<?> classObject2 = Class.forName("java.lang.String");

        System.out.println(classObject1 == classObject2);

        // ClassName.class
        Class<?> classObject3 = String.class;
        Class<?> classObject4 = int.class;

        // obj.getClass()
        TestClass objTest = new TestClass();
        Class<? extends TestClass> classObjectTest = objTest.getClass();

        // super class
        Class<?> superClass = classObjectTest.getSuperclass();
        System.out.println(superClass.getName());

        // interfaces
        Class<?>[] interfaces = classObjectTest.getInterfaces();
        for (Class<?> interfaceClass : interfaces) {
            System.out.println(interfaceClass.getName());
        }


        // getName()
        System.out.println(classObjectTest.getName());


    }
}
