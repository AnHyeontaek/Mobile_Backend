package com.catchb.web.dto.users;

import lombok.Getter;

@Getter
public class UsersResultDto {
    private String result;
    private String result1;
    private String result2;
    public UsersResultDto(String result){
        this.result = result;
    }

//    public UsersResultDto(String result1, String result2){
//        this.result1 = result1;
//        this.result2 = result2;
//    }
}
