package com.catchb.web.dto.pictures;

import com.catchb.domain.pictures.Pictures;
import lombok.Getter;


@Getter
public class PicturesResponsDto {
    private Long pictures_num;
    private String pictures_loc;
    private String pictures_name;
    private String pictures_path;


    public PicturesResponsDto(Pictures entity){
        this.pictures_num = entity.getPictures_num();
        this.pictures_loc = entity.getPictures_loc();
        this.pictures_name = entity.getPictures_name();
        this.pictures_path = entity.getPictures_path();
    }
}
