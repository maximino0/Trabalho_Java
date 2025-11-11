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
        System.out.println(login+"pu");
        User user = this.findByUsername(login);
        System.out.println(user+"po");
        if (user == null) {
            user = this.findByEmail(login);
        }
        System.out.println(user+"pe");

        return user;
    }
}
