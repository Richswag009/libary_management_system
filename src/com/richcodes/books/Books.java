package com.richcodes.books;

import java.util.Date;
import java.util.Objects;

public class Books {

    private String name;
    private String title;
    private String author ;

    private Date datePublished;
    private boolean isBorrowed;

    public Books(String name, String title, String author, Date datePublished) {
        this.name = name;
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.isBorrowed =false;
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

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
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
        Books books = (Books) o;
        return isBorrowed == books.isBorrowed && Objects.equals(name, books.name) && Objects.equals(title, books.title) && Objects.equals(author, books.author) && Objects.equals(datePublished, books.datePublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, author, datePublished, isBorrowed);
    }
}
