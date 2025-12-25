package onlinestore.controller;

import onlinestore.domain.User;
import onlinestore.domain.UserRole;
import onlinestore.exception.FileException;
import onlinestore.service.UserService;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    private static Scanner scanner = new Scanner(System.in);

    public static void Registration(UserService userService) {
        System.out.println(Constants.REGISTRATION_MENU);
        System.out.println(Constants.INPUT_LOGIN);
        String username = scanner.nextLine();
        System.out.println(Constants.INPUT_PASSWORD);
        String password = scanner.nextLine();
        System.out.println(Constants.INPUT_EMAIL);
        String email = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            User user = new User(username, password, email, UserRole.USER);
            try {
                if (userService.create(user)) {
                    System.out.println("Пользователь с логином " + username + " успешно создан");
                } else {
                    System.out.println("Не удалось создать пользователя с логином " + username);
                }
            } catch (RuntimeException e) {
                System.out.println("Регистрация не работает. Обратитесь к администратору системы");
            }
        } else {
            System.out.println("Неверно введен email");
        }
    }

    public static void addUser(UserService userService) {
        System.out.println(Constants.REGISTRATION_MENU);
        System.out.println(Constants.INPUT_LOGIN);
        String username = scanner.nextLine();
        System.out.println(Constants.INPUT_PASSWORD);
        String password = scanner.nextLine();
        System.out.println(Constants.INPUT_EMAIL);
        String email = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        System.out.println(Constants.INPUT_ROLE);
        String role = scanner.nextLine();

        if (matcher.find()) {
            User user = new User(username, password, email, role);
            try {
                if (userService.create(user)) {
                    System.out.println("Пользователь с логином " + username + " успешно создан");
                } else {
                    System.out.println("Не удалось создать пользователя с логином " + username);
                }
            } catch (RuntimeException e) {
                System.out.println("Регистрация не работает. Обратитесь к администратору системы");
            }
        } else {
            System.out.println("Неверно введен email");
        }
    }


}
