package com.richcodes;

import com.richcodes.account.AccountDao;
import com.richcodes.account.AccountService;
import com.richcodes.books.Book;
import com.richcodes.librarian.Librarian;
import com.richcodes.library.LibraryService;
import com.richcodes.user.UserService;

import java.util.Scanner;

public class Main {
    private final UserService userService;
    private final LibraryService libraryService;
    private final AccountService accountService;
    private final Librarian librarian;

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

    }

    private void userMenu(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.println("""
                    1⃣ - Get books
                    2⃣ - Search Book by title
                    3⃣ - Get All Available Books
                    4⃣ - Borrow Book
                    5⃣ - Return book
                    6⃣ - Get All Borrowed Books
                    7⃣ - Exit Program
                    """);
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
                    getAvailableBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    getBorrowedBooks();
                    break;
                case 7:
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
            System.out.println();
            System.out.println("""
                    1⃣ - Add book
                    2⃣ - Get All Books
                    3⃣ - Search Book by title
                    4⃣ - Get All Available Books
                    5⃣ - Remove Book
                    6⃣ - Update Book by title
                    7⃣ - Get All Borrowed Books
                    7⃣ - Get User Borrowed Books
                    9⃣ - Exit Program
                    """);
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
                    getAvailableBooks();
                    break;
                case 5:
                    removeBook();
                    break;
                case 6:
                    updateBook();
                    break;
                case 7:
                    getAllBorrowedBooks();
                    break;
                case 8:
                    getAUserBorrowedBooks();
                    break;
                case 9:
                    System.out.println("existing the program .......");
                    return;
                default:
                    System.out.println("invalid input");
            }
        }

    }

    ///// User Functions
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
    private void borrowBook(){
        Scanner titleScanner = new Scanner(System.in);
        Scanner authorScanner = new Scanner(System.in);
        System.out.println("Please enter The title of the book");
        String title = titleScanner.nextLine();
        System.out.println("Please enter The Author of the book");
        String author = authorScanner.nextLine();
        accountService.borrowBooks(title,author);
    }
    private void returnBook(){
        Scanner usernameScanner = new Scanner(System.in);
        Scanner borrowingIdScanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String user = usernameScanner.nextLine();
        System.out.println("Please enter The Author of the book");
        String borrowingID = borrowingIdScanner.nextLine();
        accountService.returnBook(user,borrowingID);
    }

    private void getBorrowedBooks(){
        Scanner usernameScanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String user = usernameScanner.nextLine();
        accountService.getUserBorrowedBooks(user);
    }
    /*
    Users functions ends here
     */


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

    private void getAvailableBooks(){
        libraryService.getAvailableBooks();
    }

    private void removeBook(){
        Scanner titleScanner = new Scanner(System.in);
        Scanner authorScanner = new Scanner(System.in);
        System.out.println("please enter the tile of the book u want to remove");
        String title = titleScanner.nextLine();
        System.out.println("please enter the tile of the book u want to remove");
        String author = authorScanner.nextLine();
        libraryService.removeBooksById(title,author);
    }

    private void updateBook(){
        Scanner titleScanner = new Scanner(System.in);
        Scanner authorScanner = new Scanner(System.in);
        System.out.println("please enter the tile of the book u want to Update");
        String title = titleScanner.nextLine();
        System.out.println("please enter the tile of the book u want to remove");
        String author = authorScanner.nextLine();

        // scanners for the updated book
        Scanner newTitleScanner = new Scanner(System.in);
        Scanner newAuthorScanner = new Scanner(System.in);
        Scanner bookIsbn = new Scanner(System.in);
        System.out.println("please enter the new title of the book u are updating");
        String newTitle = newTitleScanner.nextLine();
        System.out.println("please enter the Author of the book u want to Update");
        String newAuthor = newAuthorScanner.nextLine();
        System.out.println("please enter the ISBN of the book u want to Update");
        String ISBN = bookIsbn.nextLine();
        Book updatedBook = new Book(newTitle,newAuthor,ISBN);
        libraryService.updateBook(title,author,updatedBook);
    }

    private void getAllBorrowedBooks(){
        accountService.getBorrowedBooks();
    }
    private void getAUserBorrowedBooks(){
        Scanner usernameScanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String user = usernameScanner.nextLine();
        accountService.getUserBorrowedBooks(user);
    }






}