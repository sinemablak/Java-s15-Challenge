package com.library.personnel;

public abstract class Person {
    private String name;

    public Person(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public abstract void whoYouAre();

}
