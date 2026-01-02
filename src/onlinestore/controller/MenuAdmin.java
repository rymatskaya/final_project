package onlinestore.controller;

import onlinestore.repository.GoodRepository;
import onlinestore.repository.GoodRepositoryImpl;
import onlinestore.repository.UserRepository;
import onlinestore.repository.UserRepositoryImpl;
import onlinestore.service.GoodService;
import onlinestore.service.GoodServiceImpl;
import onlinestore.service.UserService;
import onlinestore.service.UserServiceImpl;

import java.util.Scanner;

public class MenuAdmin {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuAdmin() {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        GoodRepository goodRepository = new GoodRepositoryImpl();
        GoodService goodService = new GoodServiceImpl(goodRepository);

        while (true) {

            System.out.println(Constants.ADMIN_MENU);
            System.out.print(Constants.CHOISE);
            String step = scanner.nextLine();

            if (step.equals("1")) {
                System.out.println(Constants.ADD_USER);
                Functions.addUser(userService);

            } else if (step.equals("2")) {
                System.out.println(Constants.EDIT_USER);
                Functions.updateUser(userService);

            } else if (step.equals("3")) {
                System.out.println(Constants.DELETE_USER);
                Functions.deleteUser(userService);

            } else if (step.equals("4")) {
                System.out.println(Constants.VIEW_USERS);
                userService.getAllUsers().forEach(System.out::println);

            } else if (step.equals("5")) {
                Functions.addGood(goodService);
            } else if (step.equals("6")) {
                Functions.updateGood(goodService);
            } else if (step.equals("7")) {
                Functions.DeleteGood(goodService);
            } else if (step.equals("8")) {
                System.out.println(Constants.VIEW_GOODS);
                goodService.getAllGoods().forEach(System.out::println);
            } else if (step.equals("0")) {
                GlobalController.start();
                break;
            } else {
                System.out.println("Нет такого пункта меню. Попробуйте еще раз.");
            }
        }
    }


}
