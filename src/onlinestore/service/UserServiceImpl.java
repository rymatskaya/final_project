package onlinestore.service;


import onlinestore.controller.Constants;
import onlinestore.domain.User;
import onlinestore.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static onlinestore.controller.Functions.scanner;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

       public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> addUser(User user) {
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

    @Override
    public Optional<User> updateUser(String username, String password, String newUsername, String newPassword) {
        if (username == null || password == null || newUsername == null || newPassword == null ||
                username.trim().isEmpty() || password.trim().isEmpty() ||
                newUsername.trim().isEmpty() || newPassword.trim().isEmpty()) {
            return Optional.empty();
        }

        return userRepository.updateUser(username, password,newUsername,newPassword);
    }

    @Override
    public Optional<User> deleteUser(String username) {
        if (username == null || username.trim().isEmpty() ) {
            return Optional.empty();
        }

        return userRepository.deleteUser(username);
    }
}
