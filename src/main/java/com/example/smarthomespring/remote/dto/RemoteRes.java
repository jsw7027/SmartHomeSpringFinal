package com.example.smarthomespring.remote.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RemoteRes {

    private long id;

    private String remoteCode;

    private String remoteType;
}
