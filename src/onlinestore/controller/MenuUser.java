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

public class MenuUser {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuUser() {

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        GoodRepository goodRepository = new GoodRepositoryImpl();
        GoodService goodService = new GoodServiceImpl(goodRepository);

        while (true) {
            System.out.println(Constants.USER_MENU);
            System.out.print(Constants.CHOISE);
            String step = scanner.nextLine();

            if (step.equals("1")) {
                System.out.println(Constants.VIEW_GOODS);
                goodService.getAllGoods().forEach(System.out::println);
                //1 - Просмотр товаров
            } else if (step.equals("2")) {
                System.out.println(Constants.VIEW_GOOD_CATEGORY);
                System.out.println(Constants.INPUT_CATEGORY);
                String category = scanner.nextLine();
                goodService.getGoodsByCategory(category).forEach(System.out::println);
               // 2 - Просмотр товаров по категориям
            } else if (step.equals("3")) {
                System.out.println(Constants.VIEW_GOOD_CATEGORY_PRICE);
                System.out.println(Constants.INPUT_CATEGORY);
                String category = scanner.nextLine();
                System.out.println(Constants.INPUT_PRICE);
                Double price = scanner.nextDouble();
                goodService.getGoodsByCategoryPrice(category, price).forEach(System.out::println);
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

