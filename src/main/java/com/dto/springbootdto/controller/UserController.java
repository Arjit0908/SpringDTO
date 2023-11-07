package com.dto.springbootdto.controller;


import com.dto.springbootdto.dto.UserLocationDTO;
import com.dto.springbootdto.service.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @GeneratedValue(generator = "/user-location")
    @GetMapping("/user-location")
    public List<UserLocationDTO> getAllLUserLocation(){
        return userService.getAllUserLocation();
    }
}
