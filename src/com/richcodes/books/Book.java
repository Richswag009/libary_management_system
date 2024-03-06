package com.richcodes.books;

import java.util.Date;
import java.util.Objects;

public class Book {

    private String name;
    private String title;
    private String author ;

    private Date datePublished;
    private boolean isBorrowed;

    public Book(String title, String author, Date datePublished) {

        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.isBorrowed =false;
    }

    public Book(String name, String title, String author) {
        this.name = name;
        this.title = title;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void makedIsBorrowed(){
       this.isBorrowed=true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Books{" +

                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", datePublished=" + datePublished +
                ", isBorrowed=" + isBorrowed +
                '}';
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book books = (Book) o;
        return isBorrowed == books.isBorrowed && Objects.equals(title, books.title) && Objects.equals(author, books.author) && Objects.equals(datePublished, books.datePublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash( title, author, datePublished, isBorrowed);
    }
}
