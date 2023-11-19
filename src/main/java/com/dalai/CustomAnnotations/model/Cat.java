package com.dalai.CustomAnnotations.model;

import com.dalai.CustomAnnotations.annotations.ImportantString;
import com.dalai.CustomAnnotations.annotations.RunImmediately;
import com.dalai.CustomAnnotations.annotations.VeryImportant;


@VeryImportant()
public class Cat {
    @ImportantString
    String name;
    int age;
    public Cat(String name){
        this.name=name;
    }

    @RunImmediately(times=3)
    public String meow(){
        return  "MEOW !!";
    }

    public String eat(){
        return "Munch !!!";
    }
}
