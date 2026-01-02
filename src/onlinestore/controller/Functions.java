package onlinestore.controller;

import onlinestore.domain.Good;
import onlinestore.domain.GoodType;
import onlinestore.domain.User;
import onlinestore.domain.UserRole;
import onlinestore.exception.FileException;
import onlinestore.service.GoodService;
import onlinestore.service.UserService;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    public static Scanner scanner = new Scanner(System.in);

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
                if (!userService.addUser(user).isEmpty()) {
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
                if (!userService.addUser(user).isEmpty()) {
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

    public static void updateUser(UserService userService) {
        System.out.println(Constants.EDIT_USER);
        System.out.println(Constants.INPUT_LOGIN);
        String username = scanner.nextLine();
        System.out.println(Constants.INPUT_PASSWORD);
        String password = scanner.nextLine();
        System.out.println(Constants.INPUT_LOGIN_NEW);
        String newUsername = scanner.nextLine();
        System.out.println(Constants.INPUT_PASSWORD_NEW);
        String newPassword = scanner.nextLine();

        Optional<User> updatedUser = userService.updateUser(
                username, password, newUsername, newPassword
        );

        if (updatedUser.isPresent()) {
            System.out.println("Пользователь успешно обновлён!");
        } else {
            System.out.println("Ошибка: пользователь не найден или данные некорректны.");
        }
    }

    public static void deleteUser(UserService userService) {
        System.out.println(Constants.DELETE_USER);
        System.out.println(Constants.INPUT_LOGIN);
        String username = scanner.nextLine();

        Optional<User> deleteUser = userService.deleteUser(username);

        if (deleteUser.isPresent()) {
            System.out.println("Пользователь успешно удален!");
        } else {
            System.out.println("Ошибка: пользователь не найден или данные некорректны.");
        }
    }


    public static void addGood(GoodService goodService) {
        System.out.println(Constants.ADD_GOOD);
        System.out.println(Constants.INPUT_GOOD);
        String name = scanner.nextLine();
        System.out.println(Constants.INPUT_CODE);
        String code = scanner.nextLine();
        System.out.println(Constants.INPUT_BRAND);
        String brand = scanner.nextLine();
        System.out.println(Constants.INPUT_CATEGORY);
        String category = scanner.nextLine();
        System.out.println(Constants.INPUT_PRICE);
        Double price = scanner.nextDouble();
        System.out.println(Constants.INPUT_AGE);
        Integer age = scanner.nextInt();

        Good good = new Good(name, code, brand, price, age, category);
        try {
            if (!goodService.addGood(good).isEmpty()) {
                System.out.println("Товар " + name + " успешно добавлен");
            } else {
                System.out.println("Не удалось создать товар с наименованием " + name);
            }
        } catch (RuntimeException e) {
            System.out.println("Добавление товара не работает. Обратитесь к администратору системы");
        }
    }
    public static void updateGood(GoodService goodService) {
        System.out.println(Constants.EDIT_GOOD);
        System.out.println(Constants.INPUT_CODE);
        String code = scanner.nextLine();
        System.out.println(Constants.INPUT_GOOD);
        String newName = scanner.nextLine();
        System.out.println(Constants.INPUT_BRAND);
        String newBrand = scanner.nextLine();
        System.out.println(Constants.INPUT_CATEGORY);
        String newCategory = scanner.nextLine();
        System.out.println(Constants.INPUT_PRICE);
        Double newpPrice = scanner.nextDouble();
        System.out.println(Constants.INPUT_AGE);
        Integer newAge = scanner.nextInt();

        Optional<Good> updatedGood = goodService.updateGood(
                code, newName, newBrand, newCategory, newpPrice, newAge
        );

        if (updatedGood.isPresent()) {
            System.out.println("Товар успешно обновлён!");
        } else {
            System.out.println("Ошибка: товар не найден или данные некорректны.");
        }
    }

    public static void DeleteGood(GoodService goodService) {
        System.out.println(Constants.DELETE_GOOD);
        System.out.println(Constants.INPUT_CODE);
        String code = scanner.nextLine();

        Optional<Good> deleteGood = goodService.deleteGood(code);

        if (deleteGood.isPresent()) {
            System.out.println("Товар успешно удален!");
        } else {
            System.out.println("Ошибка: товар не найден или данные некорректны.");
        }
    }
}
