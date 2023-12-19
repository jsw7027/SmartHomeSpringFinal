package com.example.smarthomespring.user.controller;


import com.example.smarthomespring.user.domain.User;
import com.example.smarthomespring.user.dto.LoginReq;
import com.example.smarthomespring.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;


    @PostMapping("/login")
    public Boolean userLogin(@RequestBody LoginReq loginReq){
        System.out.println("test :: "+ loginReq.getLogin_id());

        Boolean result = authService.login(loginReq);

        return result;
    }



    @PostMapping("/register")
    public void userRegist(@RequestBody User req){
        System.out.println(req.getLogin_id());

        authService.userSignUp(req);
    }


}
