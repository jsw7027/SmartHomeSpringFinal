package com.example.smarthomespring.remote.controller;


import com.example.smarthomespring.remote.domain.Remote;
import com.example.smarthomespring.remote.dto.RemoteAddReq;
import com.example.smarthomespring.remote.dto.RemoteRes;
import com.example.smarthomespring.remote.service.RemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remote")
@RequiredArgsConstructor
public class remoteController {
    private final RemoteService remoteService;
    @GetMapping("/list")
    public List<RemoteRes> getAllRemote(){
        return remoteService.myRemoteList();
    }


    @GetMapping("/amount")
    public int getSize(){
        return remoteService.remoteSize();
    }

    @PostMapping("/register")
    public void saveRemote(@RequestBody RemoteAddReq req){

        remoteService.saveRemote(req);
    }

}
