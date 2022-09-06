package ru.project.takst_3_1_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.takst_3_1_1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById (long id);
}
