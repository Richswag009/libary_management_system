package com.richcodes.account;

import com.richcodes.books.Book;
import com.richcodes.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDao {

    private  final static List<Account> borrowedBooks;

    static {
        borrowedBooks = new ArrayList<>();
    }

    public  void borrowedBooks(Account account){
       borrowedBooks.add(account);
    }

    public  List<Account> getBorrowedBooks(){
        return borrowedBooks;
    }

    public  List<Book> getUserBorrowedBook(User user){
        List<Account> accounts = getBorrowedBooks();
        List<Book> userBook;
        userBook = accounts.stream()
                .filter(s->s.getUser() != null && s.getUser().equals(user))
                .map(Account::getBook)
                .collect(Collectors.toList());
        return userBook;

    }

    public  void returnBook(User user, String borrowingId){
        List<Account> accounts = getBorrowedBooks();
        for(var account : accounts){
            if(account.getBorrowingID().equalsIgnoreCase(borrowingId) && account.getUser().equals(user)){
                account.getBook().setBorrowed(false);
            }
        }


    }



}
