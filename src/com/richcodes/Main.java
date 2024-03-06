package com.richcodes;

import com.richcodes.user.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.getAllUsers();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        userService.getUserByUsername(choice);
    }




}