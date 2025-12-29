package onlinestore.controller;

import onlinestore.domain.User;
import onlinestore.domain.UserRole;
import onlinestore.repository.UserRepository;
import onlinestore.repository.UserRepositoryImpl;
import onlinestore.service.UserService;
import onlinestore.service.UserServiceImpl;

import java.util.Scanner;

public class GlobalController {
    private static Scanner scanner = new Scanner(System.in);
    public static User user;

    public static void start() {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
//        User user = new User(1, "admin", "qwerty", "adgs@ff.dd", "ADMIN");
//        userService.create(user);

        while (true) {
            System.out.println(Constants.MAIN_MENU);

            System.out.print(Constants.CHOISE);
            String step = scanner.nextLine();

            switch (step) {
                case "1" -> {
                    Functions.addUser(userService);
                   // Functions.Registration(userService);
                   // userService.getAllUsers().forEach(System.out::println);
                }
                case "2" -> {

                    System.out.println(Constants.INPUT_MENU);
                    System.out.println(Constants.INPUT_LOGIN);
                    String username = scanner.nextLine();
                    System.out.println(Constants.INPUT_PASSWORD);
                    String password = scanner.nextLine();

                    user = userService.getUserByLoginPassword(username, password)
                            .orElseThrow(() -> new RuntimeException(String.format("Пользователя " +
                                    "с логином %s и паролем %s не найдено ", username, password)));


                    switch (user.getRole()) {
                        case USER -> MenuUser.menuUser();
                        //case MANAGER -> MenuManager.MenuManager();
                        case ADMIN -> MenuAdmin.menuAdmin();
                    }
                }

                case "0" -> {
                    System.out.println(Constants.EXIT);
                    return;
                }
                default -> System.out.println("Нет такого пункта меню. Попробуйте еще раз.");
            }
        }
    }
}
