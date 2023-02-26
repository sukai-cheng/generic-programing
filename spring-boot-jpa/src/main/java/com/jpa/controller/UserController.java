package com.jpa.controller;

import com.jpa.entity.User;
import com.jpa.model.UserOnlyName;
import com.jpa.repository.UserRepository;
import com.jpa.utils.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jpa/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/save")
    public void addUser() {
        userRepository.save(User.builder()
                .email("test@gmail.com")
                .lastName("chengsukai")
                .address("jiangsu/suzhou")
                .sex("male")
                .build());
    }

    @PostMapping("/findByName")
    public AjaxResult findByName(@RequestBody String name) {
        UserOnlyName res = userRepository.findByLastName(name);
        return AjaxResult.success(res);
    }

}
