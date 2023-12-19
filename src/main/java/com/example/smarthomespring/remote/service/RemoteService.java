package com.example.smarthomespring.remote.service;

import com.example.smarthomespring.remote.domain.Remote;
import com.example.smarthomespring.remote.dto.RemoteAddReq;
import com.example.smarthomespring.remote.dto.RemoteRes;
import com.example.smarthomespring.remote.repository.RemoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RemoteService {
    private final RemoteRepository remoteRepository;



    public int remoteSize(){
        List<Remote> remoteList = remoteRepository.findAll();
        return remoteList.size();
    }

    public List<RemoteRes> myRemoteList(){
        List<RemoteRes> result = new ArrayList<>();


        List<Remote> remoteList = remoteRepository.findAll();

        if(remoteList != null){
            for(Remote remote : remoteList){

                result.add(
                        RemoteRes.builder()
                                .id(remote.getId())
                                .remoteCode(remote.getRemoteCode())
                                .remoteType(remote.getRemoteType())
                                .build()
                );
            }

        }else{
            System.out.println("test");

        }

        return result;
    }


    public void saveRemote(RemoteAddReq req){


        Remote remote = Remote.builder()
                .remoteCode(req.getRemoteCode())
                .remoteType(req.getRemoteType())
                .build();

        remoteRepository.save(remote);

    }
}
