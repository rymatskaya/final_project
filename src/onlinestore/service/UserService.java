package onlinestore.service;


import onlinestore.domain.User;
import onlinestore.domain.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean create(User user) ;
    Optional<User> findUserByLogin(String username)   ;
    Optional<User> getUserByLoginPassword(String username, String password) ;
    User checkPassword(String username, String password) ;
    User addUser(User user);
    List<User> getAllUsers();
}
