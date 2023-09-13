package com.basicsstrong.reflection.fields;

import java.lang.reflect.Field;

public class FieldInfo {

    public static void main(String[] args) throws Exception {
        Entity entity = new Entity(10, "id");
        Class<? extends Entity> classObject = entity.getClass();

        // non-declared: all public fields in this class and all superclasses
        Field[] fieldsPublic = classObject.getFields();

        for (Field field : fieldsPublic) {
            System.out.println(field.getName());
        }


        // declared: all fields in this class, but not superclasses
        Field[] fieldsAll = classObject.getDeclaredFields();

        for (Field field : fieldsAll) {
            System.out.println(field.getName());
        }

        Field field = classObject.getField("type");
        field.set(entity, "rollNo.");

        System.out.println(entity);


        // Field fieldPrivate = classObject.getField("val"); // java.lang.NoSuchFieldException
        Field fieldPrivate = classObject.getDeclaredField("val");
        fieldPrivate.setAccessible(true); // to access private fields otherwise IllegalAccessException
        fieldPrivate.set(entity, 191919);

        System.out.println(entity);

    }
}
