package com.example.restapi.controller;

import com.example.restapi.dto.UserDto;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getAUsers();

    }
    @PostMapping("/users")
@Transactional
    public ResponseEntity<Object> creatUser(@Valid @RequestBody  User user){







            User savedUser =  this.userService.CreateUser(user);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).build();




        //create a User entiy object






    }
    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id){
     User user =  this.userService.getAsingleUser(id);


      return user;

    }



}
