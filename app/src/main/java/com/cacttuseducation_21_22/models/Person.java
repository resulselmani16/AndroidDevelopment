package com.cacttuseducation_21_22.models;

public class Person {
    private String name;
    private int id;
    private int image;
    private int age;

    public Person(String name, int id, int age, int image) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

}
