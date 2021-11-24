package com.catchb.web.dto.pictures;

import com.catchb.domain.pictures.Pictures;
import com.catchb.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PicturesRequestDto {
    private String pictures_loc;
    private String pictures_name;
    private String pictures_path;



    public PicturesRequestDto(String pictures_loc, String pictures_name, String pictures_path) {
        this.pictures_loc = pictures_loc;
        this.pictures_name = pictures_name;
        this.pictures_path = pictures_path;
    }

    public Pictures toEntity(){
        return Pictures.builder()
                .pictures_loc(pictures_loc)
                .pictures_name(pictures_name)
                .pictures_path(pictures_path)
                .build();
    }
}
