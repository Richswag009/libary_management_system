package com.richcodes.account;

import com.richcodes.IDGenerator.IDGenerator;
import com.richcodes.books.Book;
import com.richcodes.user.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class Account {
    private  User user;
    private  Book book;
    private LocalDateTime dateCreated;
    private final LocalDateTime returningDate;
    private final IDGenerator idGenerator = new IDGenerator();
    private  String borrowingID;

    public Account(User user, Book book, LocalDateTime dateCreated ) {
        this.user = user;
        this.book = book;
        this.dateCreated = dateCreated;
        this.borrowingID = idGenerator.generateId();
        this.returningDate = dateCreated.plusDays(7);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public IDGenerator getIdGenerator() {
        return idGenerator;
    }

    public String getBorrowingID() {
        return borrowingID;
    }

    public void setBorrowingID(String borrowingID) {
        this.borrowingID = borrowingID;
    }

    public LocalDateTime getReturningDate() {
        return returningDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                " \n user=" + user +
                ",\n book=" + book +
                ",\n dateCreated=" + dateCreated +
                ",\n returningDate=" + returningDate +
                ",\n borrowingID='" + borrowingID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user) && Objects.equals(book, account.book) && Objects.equals(dateCreated, account.dateCreated) && Objects.equals(returningDate, account.returningDate) && Objects.equals(idGenerator, account.idGenerator) && Objects.equals(borrowingID, account.borrowingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book, dateCreated, idGenerator,returningDate, borrowingID);
    }
}
