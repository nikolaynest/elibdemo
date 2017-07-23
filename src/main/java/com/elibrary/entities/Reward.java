package com.elibrary.entities;

import javax.persistence.*;

/**
 * Created by nikolay on 20.07.17.
 */
@Entity
@Table(name = "rewards")
public class Reward {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reward_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Author.class)
    private Author author;
    private int year;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
