package com.richcodes.account;

import com.richcodes.books.Book;
import com.richcodes.library.LibraryService;
import com.richcodes.user.User;
import com.richcodes.user.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AccountService {

    private final AccountDao accountDao ;
    private final UserService userService;
    private final LibraryService libraryService;
    private Book book;


    public AccountService(UserService userService, LibraryService libraryService , AccountDao accountDao) {
        this.userService = userService;
        this.libraryService = libraryService;
        this.accountDao = accountDao;
    }

    public List<Account> getBorrowedBooks(){
        if (accountDao.getBorrowedBooks().isEmpty()){
            System.out.println("No book has been borrowed yet");
        }
       return accountDao.getBorrowedBooks();
    }



    public  void borrowBooks(String name, String title){
        Optional<User> optionalUser = userService.getUserByUsername(name);
        Optional<Book> optionalBook = libraryService.getBookByTitle(title);
        if(optionalUser.isPresent() && optionalBook.isPresent() && !optionalBook.get().isBorrowed()){
            User user = optionalUser.get();
            Book book = optionalBook.get();
            Account account = new Account(user, book, LocalDateTime.now());
            accountDao.borrowedBooks(account);
            book.makedIsBorrowed();
            System.out.println("successfully borrowed \n " + book + "\n and your bookingId is : " + account.getBorrowingID());
        }else {
            System.out.println("couldn't borrow book");
        }

    }
    public void getUserBorrowedBooks(String name){
        Optional<User> getUser = userService.getUserByUsername(name);
        if(getUser.isEmpty()){
            System.out.println("User wasn't found ");
        }
        if(getUser.isPresent()){
            User user = getUser.get();
            if ((accountDao.getUserBorrowedBook(user).isEmpty())){
                System.out.println("User doesn't have any borrowed books");
            }
            accountDao.getUserBorrowedBook(user).forEach(System.out::println);
        }
        else{
            System.out.println("No borrowed book for user ");
        }
    }

    public void returnBook(String user, String borrowingID){

        if (user.isEmpty() || borrowingID.isEmpty()){
            System.out.println("field cannot be empty");
        }
        Optional<User> getUserOptional = userService.getUserByUsername(user);
        if (getUserOptional.isPresent()){
            User getuser = getUserOptional.get();
            for(var books : getBorrowedBooks()){
                if (books.getBorrowingID().equalsIgnoreCase(borrowingID)){
                    accountDao.returnBook(getuser,borrowingID);
                    System.out.println("successfully returned book  with BorrowingID: " + borrowingID) ;
                    break;
                }else{
                    System.out.println("Wrong borrowing ID");
                }
            }
        }else{
            System.out.println("cannot return book");
        }
    }
}
