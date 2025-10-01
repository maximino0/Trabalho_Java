package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    default User findByUsernameOrEmail(String login) {
        User user = findByUsername(login);
        if (user == null) {
            user = findByEmail(login);
        }
        return user;
    }
}
