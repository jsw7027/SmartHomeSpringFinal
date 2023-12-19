package com.example.smarthomespring.user.service;


import com.example.smarthomespring.remote.domain.Remote;
import com.example.smarthomespring.remote.dto.RemoteAddReq;
import com.example.smarthomespring.user.domain.User;
import com.example.smarthomespring.user.dto.LoginReq;
import com.example.smarthomespring.user.dto.UserDetail;
import com.example.smarthomespring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public Boolean login(LoginReq user){
        Optional<User> response = userRepository.findUserByLoginId(user.getLogin_id());

        if(!response.isEmpty()){
            if(user.getLogin_pw().equals(response.get().getLogin_pw())){
                UserDetail res = UserDetail.builder()
                        .login_id(response.get().getLogin_id())
                        .build();
                return true;
            }else{
                System.out.println("invalid pw");
                return false;
            }
        }else{
            System.out.println("no Id exist");
            return false;
        }

    }


    public void userSignUp(User user){


        User user1 = User.builder()
                .login_id(user.getLogin_id())
                .login_pw(user.getLogin_pw())
                .build();

        userRepository.save(user1);

    }


}
