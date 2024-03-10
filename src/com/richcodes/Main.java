package com.richcodes;

import com.richcodes.account.AccountDao;
import com.richcodes.account.AccountService;
import com.richcodes.library.LibraryService;
import com.richcodes.user.UserService;

import java.util.Date;

public class Main {
    private UserService userService;
    private LibraryService libraryService;
    private AccountService accountService;

    public Main(UserService userService, LibraryService libraryService, AccountDao accountDao) {
        this.userService = userService;
        this.libraryService = libraryService;
        this.accountService = new AccountService(userService,libraryService,accountDao);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        LibraryService libraryService = new LibraryService();
        AccountDao accountDao = new AccountDao();
        AccountService accountService = new AccountService(userService,libraryService,accountDao);



        userService.getAllUsers();

//        Scanner scanner = new Scanner(System.in);
//        String choice = scanner.nextLine();
//        userService.getUserByUsername(choice);
        System.out.println("--------------------------");

        libraryService.getAvailableBooks();
        System.out.println("---------------");
        libraryService.addBooks("hello","title", new Date(1 / 1995));
        libraryService.addBooks("how are u","titles", new Date(1 / 1995));
        libraryService.getAllBooks();
        libraryService.addBooks("All Nigerians Men Are mad","title", new Date(7 / 1995));
        libraryService.getAllBooks();
        libraryService.getBookByTitle("hello");
//        libraryService.removeBooksById("title","john snow");
//        libraryService.getAllBooks();
//        System.out.println("---------------");
//        Book updateBook = new Book("the subtle art to not giving a fuck","ryan Holiday",new Date(12/5/1990));
//        libraryService.updateBook("hello","title",updateBook);
//        libraryService.getAllBooks();
        System.out.println("---------------");
        libraryService.getAvailableBooks();
        System.out.println("---------------");
//
        accountService.borrowBooks("olin.veum","All Nigerians Men Are mad");
        accountService.borrowBooks("olin.veum","how are u");
        System.out.println("---------");
        accountService.getBorrowedBooks().forEach(System.out::println);
        System.out.println("------ ends here");
        accountService.getUserBorrowedBooks("olin.veum");
        System.out.println("-".repeat(20));
        accountService.getUserBorrowedBooks("joesph.ohara");

        System.out.println("-".repeat(30));
        accountService.returnBook("olin.veum","ESL0001");

    }




}