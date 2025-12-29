package onlinestore.service;


import onlinestore.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean create(User user) ;
    boolean findUserByLogin(String username)   ;
    Optional<User> getUserByLoginPassword(String username, String password) ;
    Optional<User> addUser(User user);
    List<User> getAllUsers();
    Optional<User> updateUser( String username, String password, String newUsername, String newPassword);
}
