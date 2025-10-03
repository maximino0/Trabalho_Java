package com.example.demo.Services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public boolean Exist(User user) {
        Example<User> example = Example.of(user);
        return repository.exists(example);
    }

    public boolean Cadastrar(User user){
        return (this.repository.findByUsername(user.getUsername())==null && this.repository.findByEmail(user.getEmail())==null);
    }
}
