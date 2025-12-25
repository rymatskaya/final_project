package onlinestore.controller;


import onlinestore.repository.UserRepository;
import onlinestore.repository.UserRepositoryImpl;
import onlinestore.service.UserService;
import onlinestore.service.UserServiceImpl;

import java.util.Scanner;

public class MenuUser {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuUser() {

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        while (true) {
            System.out.println(Constants.USER_MENU);
            System.out.print(Constants.CHOISE);
            String step = scanner.nextLine();

            if (step.equals("1")) {
                System.out.println(Constants.INPUT_ROLE);
                //1 - Просмотр товаров
            } else if (step.equals("2")) {
                System.out.println(Constants.INPUT_ROLE);
               // 2 - Просмотр товаров по категориям
            } else if (step.equals("3")) {
                System.out.println(Constants.INPUT_ROLE);
                //3 - Просмотр товаров по стоимости и категориям
            } else if (step.equals("0")) {
                GlobalController.start();
                break;
            } else {
                System.out.println("Нет такого пункта меню. Попробуйте еще раз.");
            }
        }
    }

}

