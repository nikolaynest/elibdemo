package com.elibrary.entities;

/**
 * Created by nikolay on 20.07.17.
 */
public enum Sex {

    MALE("male"), FEMALE("female");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
