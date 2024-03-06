package com.richcodes.library;


import com.richcodes.books.Book;

import java.util.Date;

public class LibraryService {
    public final LibraryDao libraryDao= new LibraryDao();

    public void addBooks(String title,String author, Date publishDate){
        libraryDao.addBooks( title, author, publishDate);
        System.out.println("added books successfully");
    }

    public void getAllBooks(){
        libraryDao.getBooks().forEach(System.out::println);
    }

    public  void getBookByTitle(String title){
        libraryDao.findBookByTitle(title)
                .ifPresentOrElse(book -> System.out.println("found book \n" + book),
                        ()-> System.out.println("\u001b[31" + "book was not found"));
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
