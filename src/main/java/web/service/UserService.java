package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findById(Long id);
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUserByName(String name);
}
