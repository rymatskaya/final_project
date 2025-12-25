package onlinestore.repository;

import onlinestore.controller.Constants;
import onlinestore.domain.User;
import onlinestore.domain.UserRole;
import onlinestore.exception.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    public static List<User> users = new ArrayList<>();
//    @Override
//    public Optional<User> findUserByLogin(String username) {
//        if (username == null || username.trim().isEmpty()) {
//            return false;
//        }
//
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Constants.FILEPATH))) {
//            List<User> userList;
//            userList = (List<User>) objectInputStream.readObject();
//            for (User user : userList) {
//                if (user.getUsername().equals(username)) {
//                    return true;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Файл не найден: " + Constants.FILEPATH);
//            return false;
//        } catch (IOException | ClassNotFoundException e) {
//            System.err.println("Ошибка при десериализации: " + e.getMessage());
//            return false;
//        }
//        return false;
//    }

    @Override
    public boolean create(User user) {
        String username = user.getUsername();
        //boolean IsNotExistsUser = checkUserByLogin(username);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constants.FILEPATH))) {
            //    if (!IsNotExistsUser) {
            objectOutputStream.writeObject(user);
            System.out.println("Пользователь успешно добавлен!");
            objectOutputStream.close();
            return true;
            //   } else
            //       throw new RuntimeException(String.format("Пользователь существует %s ", username));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findUserByLogin(String username) {
        return Optional.empty();
    }


    //    @Override
//    public User getUserByLoginPassword(String username, String password) {
//
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Constants.FILEPATH))) {
//            Object rawData = objectInputStream.readObject();
//
//            if (!(rawData instanceof List)) {
//                System.err.println("Некорректный формат файла: ожидался List<User>");
//                return null;
//            }
//
//            List<User> users = (List<User>) rawData;
//
//            for (User user : users) {
//              if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
//                    return user;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Файл не найден: " + Constants.FILEPATH);
//        } catch (IOException e) {
//            System.err.println("Ошибка чтения файла: " + e.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.err.println("Ошибка десериализации класса: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Неожиданная ошибка: " + e.getMessage());
//        }
//
//        return null;
//    }
    @Override
    public Optional<User> getUserByLoginPassword(String username, String password) {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Constants.FILEPATH))) {
            Object object = objectInputStream.readObject();

            if (object instanceof List<?>) {
                users = (List<User>) object;
            }

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return Optional.of(user);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + Constants.FILEPATH);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {

        Object object = deserializeObject(Constants.FILEPATH);
        if (object instanceof List<?>) {
            users = (List<User>) object;
        }
        return users;
    }

    @Override
    public User addUser(User user) {
        users = getAllUsers();
        users.add(user);
        serializeObject(users, Constants.FILEPATH);
        return user;
    }

    public Object deserializeObject(String path) {
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            object = objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + Constants.FILEPATH);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
        } catch (Throwable e) {
            return new Object();
        }
        return object;
    }

    public void serializeObject(Object object, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(object);
        } catch (Throwable e) {
            throw new FileException("Файл не найден!");
        }
    }
}
