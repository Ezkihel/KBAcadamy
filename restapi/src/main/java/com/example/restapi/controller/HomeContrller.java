package com.example.restapi.controller;

import com.example.restapi.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContrller {
    @GetMapping("/")
    public String Home(){
        return "Hi I am from the server,welcome to my shop";

    }

    @GetMapping("/hello")
    public HelloWorld  Hello(){
        return new HelloWorld("Hi Welcome to Spring Data");
    }
    @GetMapping("/hello/{name}")
    public HelloWorld  Hello2(@PathVariable String name){
        return new HelloWorld("Hi Welcome to Spring Data_" + name);
    }
}
