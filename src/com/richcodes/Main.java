package com.richcodes;

import com.richcodes.account.AccountDao;
import com.richcodes.account.AccountService;
import com.richcodes.librarian.Librarian;
import com.richcodes.library.LibraryService;
import com.richcodes.user.UserService;

import java.util.Scanner;

public class Main {
    private UserService userService = new UserService();
    private LibraryService libraryService;
    private AccountService accountService;
    private Librarian librarian;

    public Main(UserService userService, LibraryService libraryService, AccountDao accountDao, Librarian librarian) {
        this.userService = userService;
        this.libraryService = libraryService;
        this.librarian = librarian;
        this.accountService = new AccountService(userService,libraryService,accountDao);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        LibraryService libraryService = new LibraryService();
        AccountDao accountDao = new AccountDao();
        Librarian librarian1 = new Librarian();
        Main mainInstance = new Main(userService,libraryService,accountDao, librarian1);
        System.out.println();
        System.out.println("Welcome to Edo State Library!!!");
        System.out.println("Please Select Your role!!!");
        Scanner scanner = new Scanner(System.in);
            System.out.println(" 1⃣ - Users ");
            System.out.println(" 2⃣ - Librarian ");
            System.out.println(" 3⃣ - Exit the Program ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    mainInstance.userMenu();
                    break;
                case 2:
                    mainInstance.librarianMenu();
                    break;
                case 3:
                    System.out.println("existing the program");
                    return;
                default:
                    System.out.println("invalid input");
            }

//        userService.getAllUsers();

//        Scanner scanner = new Scanner(System.in);
//        String choice = scanner.nextLine();
//        userService.getUserByUsername(choice);
//        System.out.println("--------------------------");
//
//        libraryService.getAvailableBooks();
//        System.out.println("---------------");
//        libraryService.addBooks("hello","title", new Date(1 / 1995));
//        libraryService.addBooks("how are u","titles", new Date(1 / 1995));
//        libraryService.getAllBooks();
//        libraryService.addBooks("All Nigerians Men Are mad","title", new Date(7 / 1995));
//        libraryService.getAllBooks();
//        libraryService.getBookByTitle("hello");
//        libraryService.removeBooksById("title","john snow");
//        libraryService.getAllBooks();
//        System.out.println("---------------");
//        Book updateBook = new Book("the subtle art to not giving a fuck","ryan Holiday",new Date(12/5/1990));
//        libraryService.updateBook("hello","title",updateBook);
//        libraryService.getAllBooks();
//        System.out.println("---------------");
//        libraryService.getAvailableBooks();
//        System.out.println("---------------");
//
//        accountService.borrowBooks("olin.veum","All Nigerians Men Are mad");
//        accountService.borrowBooks("olin.veum","how are u");
//        System.out.println("---------");
//        accountService.getBorrowedBooks().forEach(System.out::println);
//        System.out.println("------ ends here");
//        accountService.getUserBorrowedBooks("olin.veum");
//        System.out.println("-".repeat(20));
//        accountService.getUserBorrowedBooks("joesph.ohara");
//
//        System.out.println("-".repeat(30));
//        accountService.returnBook("olin.veum","ESL0001");

    }

    private void userMenu(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(" 1⃣ - get all books");
            System.out.println(" 2⃣ - Search Book by title ");
            System.out.println(" 3⃣ - Exit the Program ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getBooks();
                    break;
                case 2:
                    searchBookByTitle();
                    break;
                case 3:
                    System.out.println("existing the program");
                    return;
                default:
                    System.out.println("invalid input");
            }
        }


        }

    private void librarianMenu() {
        System.out.println("Welcome, Please enter Password to continue");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        if (title.equalsIgnoreCase(librarian.getPassword())) {
            System.out.println("Welcome " + librarian.getName());
        }else{
            System.out.println("Wrong Password");
            return;
        }
        while (true) {
            System.out.println(" 1⃣ - Add book");
            System.out.println(" 2⃣ - Get All Books ");
            System.out.println(" 3⃣ - Search Book by title ");
            System.out.println(" 3⃣ - Exit the Program ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    getAllBooks();
                    break;
                case 3:
                  searchBookByTitle();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("invalid input");
            }
        }

    }

    /////user
    private void getBooks(){
       libraryService.getAvailableBooks();
        System.out.println("-".repeat(20));
    }
    private void searchBookByTitle(){
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        libraryService.getBookByTitle(title);
        System.out.println("-".repeat(20));
    }

    /*
    librarian functions
     */
    private void  addBook(){
        Scanner titleScanner = new Scanner(System.in);
        Scanner authorScanner = new Scanner(System.in);
        Scanner dateScanner = new Scanner(System.in);
        System.out.println("Please enter The title of the book");
        String title = titleScanner.nextLine();
        System.out.println("Please enter The Author of the book");
        String author = authorScanner.nextLine();
        System.out.println("Please enter ISBN number");
        String isbn = dateScanner.nextLine();
        libraryService.addBooks(title,author, isbn);
    }

    private void getAllBooks(){
        libraryService.getAllBooks();
    }






}