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

}
