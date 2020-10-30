package com.example.restapi.service;

import com.example.restapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
              // get all users from the database
                List<User> getAUsers();
              // get a single user from the database
                User getAsingleUser(int i);
              // update user
                User updateUser(int i,User u);
              // create user
               User CreateUser(User u);
              // delete User
               void deleteAUse(int i);
}
