package onlinestore.service;


import onlinestore.domain.User;
import onlinestore.domain.UserRole;
import onlinestore.exception.ClientException;
import onlinestore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public boolean create(User user) {
        Optional<User> optionalUser = userRepository.findUserByLogin(user.getUsername());
        if (optionalUser.isEmpty()) {
            return userRepository.create(user);
        }
        throw new RuntimeException("Пользователь с таким именем существует!");
    }

    @Override
    public Optional<User> findUserByLogin(String username) {
        return Optional.empty();
    }

//    @Override
//    public boolean checkUserByLogin(String username) {
//        return userRepository.checkUserByLogin(username);
//    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User checkPassword(String username, String password) {
        if (username == null || password == null ||
                username.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        List <User> users = userRepository.getAllUsers();
        User user = (User) users.stream()
                .filter(user1 -> user1.getUsername().equals(username));
                //.orElseThrow(() -> new ClientException("Пользователь с таким логином не найден!"));
        if (!(user.getPassword().equals(password))) {
            throw new ClientException("Неверно введен пароль!");
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Optional<User> getUserByLoginPassword(String username, String password) {
        if (username == null || password == null ||
                username.trim().isEmpty() || password.trim().isEmpty()) {
            return Optional.empty();
        }
        return userRepository.getUserByLoginPassword(username, password);
    }
}
