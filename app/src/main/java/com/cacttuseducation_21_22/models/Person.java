package com.cacttuseducation_21_22.models;

public class Person {
    private String name;
    private int id;
    private int age;
    private int image;

    public Person(String name, int id, int age, int image) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getImage(){
        return image;
    }

    public int getId() {
        return id;
    }

    public int getAge(){
        return age;
    }

}

