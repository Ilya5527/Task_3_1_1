package ru.project.takst_3_1_1.service;



import ru.project.takst_3_1_1.entity.User;

import java.util.List;

public interface UserService {


    void add(User user);

    void delete(long id);

    List<User> getAllUsers();

    User getUserById(long id);

    void update(User changedUser);
}
