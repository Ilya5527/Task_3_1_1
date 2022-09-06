package ru.project.takst_3_1_1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.takst_3_1_1.entity.User;
import ru.project.takst_3_1_1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void add(User user) {
        repository.save(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        Optional optional = repository.findById(id);
        if (optional.isPresent()) {
            return (User) optional.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void update(User changedUser) {
        repository.save(changedUser);
    }
}
