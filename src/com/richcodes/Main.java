package com.richcodes;

import com.richcodes.books.Book;
import com.richcodes.library.LibraryService;
import com.richcodes.user.UserService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.getAllUsers();

//        Scanner scanner = new Scanner(System.in);
//        String choice = scanner.nextLine();
//        userService.getUserByUsername(choice);
        LibraryService libraryService = new LibraryService();
        libraryService.addBooks("hello","title", new Date(1 / 1995));
        libraryService.addBooks("how are u","titles", new Date(1 / 1995));
        libraryService.getAllBooks();
        libraryService.addBooks("All Nigerians Men Are mad","title", new Date(7 / 1995));
        libraryService.getAllBooks();
        libraryService.getBookByTitle("titled");
        libraryService.removeBooksById("title","john snow");
        libraryService.getAllBooks();
        Book updateBook = new Book("the subtle art to not giving a fuck","ryan Holiday",new Date(12/5/1990));
        libraryService.updateBook("hello","title",updateBook);
        libraryService.getAllBooks();
    }




}