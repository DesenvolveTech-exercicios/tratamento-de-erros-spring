package com.DesenvolveTech.ExercicioExceptions.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dog {
    private int id;
    private String name;
    private int age;

    public Dog(){}

    public Dog(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public static Dog of(int i, String benji, int i1) {
        return new Dog(i, benji, i1);
    }
}
