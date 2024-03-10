package com.richcodes.Circulation;

import com.richcodes.IDGenerator.IDGenerator;
import com.richcodes.books.Book;
import com.richcodes.librarian.Librarian;
import com.richcodes.user.User;

import java.util.Date;
import java.util.Objects;

public class Circulation {
    private final User user;
    private  Librarian librarian;
    private final Book book;
    private final Date dateCreated;
    private final IDGenerator idGenerator = new IDGenerator();

    private final String borrowingID;

    public Circulation(User user, Book book) {
        this.user = user;
        this.book = book;
        this.dateCreated= new Date();
        this.borrowingID= idGenerator.generateId();

    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public IDGenerator getIdGenerator() {
        return idGenerator;
    }

    public String getBorrowingID() {
        return borrowingID;
    }

    @Override
    public String toString() {
        return "Circulation{" +
                "user=" + user +
                ", book=" + book +
                ", dateCreated=" + dateCreated +
                ", borrowingID='" + borrowingID + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulation that = (Circulation) o;
        return Objects.equals(user, that.user) && Objects.equals(book, that.book) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(idGenerator, that.idGenerator) && Objects.equals(borrowingID, that.borrowingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book, dateCreated, idGenerator, borrowingID);
    }
}
