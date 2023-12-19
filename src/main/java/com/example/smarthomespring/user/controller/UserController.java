package com.example.smarthomespring.user.controller;


import com.example.smarthomespring.remote.dto.RemoteAddReq;
import com.example.smarthomespring.user.domain.User;
import com.example.smarthomespring.user.dto.LoginReq;
import com.example.smarthomespring.user.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    AuthService authService;

    @PostMapping("/login")
    public void userLogin(@RequestParam(name = "id", required = false) Long id,
                           LoginReq loginReq){

        authService.login(loginReq);
    }



    @PostMapping("/register")
    public void userRegist(@RequestBody User req){

        authService.userSignUp(req);
    }


}
