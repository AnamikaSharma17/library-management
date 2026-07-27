package com.library.model;
import jakarta.persistence.*;

@Entity @Table(name = "books")
public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    @Id @GeneratedValue
    private Long id;

    Book(){}

    Book(String title, String author, String genre, int year){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }
    public String getTitle() {
            return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
    public Long getId(){
        return id;
    }

}
