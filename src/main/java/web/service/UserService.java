package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void update(User user);
    void delete(int id);

    User getUserById(int id);
    List<User> getAllUser();
}
