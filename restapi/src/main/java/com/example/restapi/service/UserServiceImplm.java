package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplm implements UserService{
    @Autowired
    UserRepository userRepo;
    @Override
    public List<User> getAUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public User getAsingleUser(int i) {
            User user = this.userRepo.findById(i).orElse(null);
            return user;
    }

    @Override
    public User updateUser(int i, User u) {
        return null;
    }

    @Override
    public User CreateUser(User u) {
          return this.userRepo.save(u);

    }

    @Override
    public void deleteAUse(int i) {

    }
}
