//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    default User findByUsernameOrEmail(String login) {
        User user = this.findByUsername(login);
        if (user == null) {
            user = this.findByEmail(login);
        }

        return user;
    }
}
