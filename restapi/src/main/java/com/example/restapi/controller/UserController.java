package com.example.restapi.controller;

import com.example.restapi.dto.UserDto;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
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
    UserRepository userRepo;
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userRepo.findAll();

    }
    @PostMapping("/users")
@Transactional
    public ResponseEntity<Object> creatUser(@Valid @RequestBody  User user){







            User savedUser =  this.userRepo.save(user);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).build();




        //create a User entiy object






    }
    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id){
     User user =  this.userRepo.findById(id).orElseThrow(()->
             new UserNotFoundException("User not found"));



      return user;

    }
    @DeleteMapping("/users/{id}")
    public void deletAUser(@PathVariable int id){
        this.userRepo.deleteById(id);
    }
    @PutMapping("/users/{id}")
      public User updateUser(@PathVariable int id,@Valid @RequestBody UserDto userdto)  {
              User user =   this.userRepo.findById(id).orElse(null);
                  user.setName(userdto.getNameDto());
                 return this.userRepo.save(user);

    }


}
