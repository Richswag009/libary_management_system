package com.richcodes.library;

import com.richcodes.Circulation.Circulation;
import com.richcodes.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private final List<Book> book;
    private final List<Circulation> circulations;

    public Library() {
        this.circulations = new ArrayList<>();
        this.book = new ArrayList<>();
    }

    public List<Book> getBook() {
        return book;
    }

    public List<Circulation> getCirculations() {
        return circulations;
    }

    @Override
    public String toString() {
        return "Library{" +
                "book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(book, library.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
