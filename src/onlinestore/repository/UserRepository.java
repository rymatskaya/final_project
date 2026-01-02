package onlinestore.repository;


import onlinestore.domain.User;
import onlinestore.domain.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {

    boolean findUserByLogin(String username)  ;
    Optional<User> getUserByLoginPassword(String username, String password);
    List<User> getAllUsers();
    Optional<User> addUser(User user);
    Optional<User> updateUser( String username, String password, String newUsername, String newPassword);
    Optional<User> deleteUser( String username);
    Optional<User> getUserByLogin(String username);
}
