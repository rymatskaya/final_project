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

    @Override
    public boolean findUserByLogin(String username) {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Constants.FILEPATH))) {
            List<User> userList;
            userList = (List<User>) objectInputStream.readObject();
            for (User user : userList) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + Constants.FILEPATH);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при десериализации: " + e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public boolean create(User user) {
        String username = user.getUsername();
        users = getAllUsers();
        users.add(user);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constants.FILEPATH))) {
            if (findUserByLogin(username)) {
                objectOutputStream.writeObject(users);
                System.out.println("Пользователь успешно добавлен!");
                objectOutputStream.close();
                return true;
            } else
                throw new RuntimeException(String.format("Пользователь существует %s ", username));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<User> updateUser( String username, String password,  String newUsername, String newPassword) {

        Optional<User> userOptional = getUserByLoginPassword(username, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            user.setUsername(newUsername);
            user.setPassword(newPassword); // В продакшене — хешировать!

            serializeObject(users, Constants.FILEPATH);

            return Optional.of(user);
        } else {
            return Optional.empty(); // Пользователь не найден
        }

    }

    @Override
    public Optional<User> getUserByLoginPassword(String username, String password) {
            users = getAllUsers();

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return Optional.of(user);
                }
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
    public Optional<User> addUser(User user) {
        users = getAllUsers();
        if (!(findUserByLogin(user.getUsername()))) {
            users.add(user);
            serializeObject(users, Constants.FILEPATH);
            System.out.println("Пользователь успешно добавлен!");
            return Optional.of(user);
        } else
            throw new RuntimeException(String.format("Пользователь существует %s ", user.getUsername()));
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
