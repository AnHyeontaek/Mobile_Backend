package com.catchb.web.dto.pictures;

import lombok.Getter;

@Getter
public class PicturesResultDto {
    private String pictures_path;
    public PicturesResultDto(String pictures_path){
        this.pictures_path = pictures_path;
    }
}
