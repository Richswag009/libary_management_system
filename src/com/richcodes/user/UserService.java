package com.richcodes.user;

import java.util.Optional;

public class UserService {

    private  final UserFileData userDao = new UserFileData();

    public void getAllUsers(){
          userDao.getUsers().forEach(System.out::println);
    }

    public  Optional<User> getUserByUsername(String username){
        Optional<User> userOptional = Optional.ofNullable(userDao.findUser(username));
        userOptional.ifPresentOrElse(
                user-> System.out.println("found user" + user),
                ()-> System.out.println("user not found"));
        return userOptional;

    }



    @Override
    public String toString() {
        return super.toString();
    }
}
