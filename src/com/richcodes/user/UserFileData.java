package com.richcodes.user;


import com.richcodes.books.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserFileData implements UserDao {
    private final List<User> users = new ArrayList<>();
    private List<Book> books;
    public List<User> getUsers(){
        File file = new File("src/com/richcodes/users.csv");

        try {
            Scanner    scanner = new Scanner(file);
            while(scanner.hasNext()){
                String[] parts = scanner.nextLine().split(",");
                UUID id = UUID.fromString(parts[1]);
                String name = parts[0];
                String email = parts[2];
                String username = parts[3];
                users.add(new com.richcodes.user.User(name,id,email,username));
            }
            return users;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public User findUser(String username) {
//        this.getUsers().stream().filter(s->s.getUsername().equalsIgnoreCase(username)).map(User::getUsername)
        for (var user: getUsers()){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return  null;
    }

    public void borrowBook(String username, String title, String author){
        findUser(username);

    }



}
