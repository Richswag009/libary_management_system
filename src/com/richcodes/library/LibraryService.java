package com.richcodes.library;


import com.richcodes.books.Book;

import java.util.Date;
import java.util.Optional;

public class LibraryService {
    public final LibraryDao libraryDao= new LibraryDao();

    public void addBooks(String title,String author, Date publishDate){
        libraryDao.addBooks( title, author, publishDate);
        System.out.println("added books successfully");
    }

    public void getAllBooks(){
        libraryDao.getBooks().forEach(System.out::println);
    }

    public  Optional<Book> getBookByTitle(String title){
        Optional<Book> book = (libraryDao.findBookByTitle(title));
        book.
                ifPresentOrElse(books -> System.out.println("found book \n" + books),
                        ()-> System.out.println("book was not found or dosen`t exist"));
     return book;
    }

    public  void removeBooksById(String title, String author){
        if(!libraryDao.deleteBookByAuthorAndTitle(title, author).isEmpty()){
            System.out.println("successfully deleted book");
        }else{
            System.out.println( libraryDao.deleteBookByAuthorAndTitle(title, author));
            System.out.println("cannot");
        }
    }

    public void updateBook(String title, String author, Book updatedBook){
        if(title.isEmpty() && author.isEmpty()){
            System.out.println("Field cannot be Empty");
        }
        libraryDao.updateBookByTitle(title,author,updatedBook);
    }

    public  void  getAvailableBooks(){
        if (libraryDao.availableBooks().isEmpty()){
            System.out.println("No Available Books");
        }
        libraryDao.availableBooks().forEach(System.out::println);

    }

}
