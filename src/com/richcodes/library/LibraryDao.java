package com.richcodes.library;

import com.richcodes.books.Book;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryDao {

    private List<Book> books = new ArrayList<>();

    public void addBooks( String title, String author, Date publishDate){
        books.add(new Book(title,author,publishDate));
    }
    public List<Book> getBooks(){
        return books;
    }
    public Optional<Book> findBookByTitle(String title){
        for (Book book : getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)){
                return Optional.of(book);
            }
            return Optional.empty();
        }
        return  Optional.empty();
    }


    public List<Book> deleteBookByAuthorAndTitle(String title, String author){
        books = books.stream()
                .filter(book -> !(book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)))
                .collect(Collectors.toList());
        return books;
    }

    public  void updateBookByTitle(String title,String author, Book updatedBook  ){
        Optional<Book> optionalBook = getBooks().stream().filter(s->s.getTitle().equalsIgnoreCase(title)
                        && s.getAuthor().equalsIgnoreCase(author))
                .findFirst();

        if(optionalBook.isPresent()){
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            System.out.println("Successfully Updated book" + existingBook);
        }else{
            System.out.println("Book not found with title '" + title + "' and author '" + author + "'");
        }

    }

    public List<Book> availableBooks() {
        return books.stream()
                .filter(book -> !book.isBorrowed())
                .toList();

    }


}
