package onlinestore.controller;

public class Constants {
    public static final String FILEPATH = "d:\\Java\\project\\shop\\final_project\\users.ser";
    public static final String FILEPATHGOODS = "d:\\Java\\project\\shop\\final_project\\goods.ser";
    public static final String MAIN_MENU = """
            Добро пожаловать!
            1 - Регистрация пользователя
            2 - Авторизация пользователя
            0 - Выход
            """;
    public static final String CHOISE = "Выберите пункт меню: ";
    public static final String REGISTRATION_MENU = "Меню регистрации";
    public static final String INPUT_LOGIN = "Введите логин:";
    public static final String INPUT_PASSWORD = "Введите пароль:";
    public static final String INPUT_LOGIN_NEW = "Введите новый логин:";
    public static final String INPUT_PASSWORD_NEW = "Введите новый пароль:";
    public static final String INPUT_EMAIL = "Введите email:";
    public static final String INPUT_ROLE = "Введите роль:";
    public static final String INPUT_MENU = "Меню входа";
    public static final String EXIT = "Выход";
    public static final String USER_MENU = """
             1 - Просмотр товаров
             2 - Просмотр товаров по категориям
             3 - Просмотр товаров по стоимости и категориям
             0 - Вернуться в главное меню                   
            """;
     public static final String ADMIN_MENU = """
            Пользователи
             1 - Добавить пользователя
             2 - Изменить пользователя
             3 - Удалить пользователя
             4 - Просмотр пользователей
             Товары
             5 - Добавить товар
             6 - Изменить товар
             7 - Удалить товар
             8 - Просмотр товаров
             
             0 - Вернуться в главное меню                   
            """;
    public static final String INPUT_GOOD = "Введите нименование товара:";
    public static final String INPUT_CODE = "Введите код товара:";
    public static final String INPUT_BRAND = "Введите брэнд товара:";
    public static final String INPUT_CATEGORY = "Введите категорию товара:";
    public static final String INPUT_AGE = "Введите ограничение по возрасту товара:";
    public static final String INPUT_PRICE = "Введите цену товара:";

    public static final String ADD_USER = "Добавление пользователя";
    public static final String EDIT_USER = "Изменение пользователя";
    public static final String DELETE_USER = "Удаление пользователя";
    public static final String VIEW_USERS = "Просмотр пользователей";

    public static final String ADD_GOOD = "Добавление товара";
    public static final String EDIT_GOOD = "Изменение товара";
    public static final String DELETE_GOOD = "Удаление товара";
    public static final String VIEW_GOODS = "Просмотр товаров";

    public static final String VIEW_GOOD_CATEGORY = "Просмотр товаров по категориям: ";
    public static final String VIEW_GOOD_CATEGORY_PRICE = "Просмотр товаров по категориям и цене:";
}
