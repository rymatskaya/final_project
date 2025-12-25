package onlinestore.repository;


import onlinestore.domain.User;
import onlinestore.domain.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {

    boolean create(User user) ;
    Optional<User> findUserByLogin(String username)  ;
    Optional<User> getUserByLoginPassword(String username, String password);
    // User getUserByLoginPassword(String username, String password);
    List<User> getAllUsers();
    User addUser(User user);
}
