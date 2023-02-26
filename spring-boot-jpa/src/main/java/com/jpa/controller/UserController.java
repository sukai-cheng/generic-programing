package com.jpa.controller;

import com.jpa.entity.User;
import com.jpa.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jpa/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/save")
    public void addUser() {
        userRepository.save(User.builder().email("test@gmail.com").lastName("chengsukai").build());
    }

}
