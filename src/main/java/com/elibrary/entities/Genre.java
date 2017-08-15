package com.elibrary.entities;

/**
 * Created by nikolay on 20.07.17.
 */
public enum Genre {

    ROMANCE("Romance"),
    NOVEL("Novel"),
    FANTASY("Fantasy"),
    SCIFI("SciFi"),
    CRIME("Crime"),
    SCIENCE("Science"),
    PROGRAMMING("Programming");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
