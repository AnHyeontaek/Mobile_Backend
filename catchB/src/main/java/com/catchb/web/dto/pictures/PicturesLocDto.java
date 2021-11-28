package com.catchb.web.dto.pictures;

import lombok.Getter;

@Getter
public class PicturesLocDto {
    private String pictures_loc;

    public PicturesLocDto(String pictures_loc){
        this.pictures_loc = pictures_loc;
    }
}
