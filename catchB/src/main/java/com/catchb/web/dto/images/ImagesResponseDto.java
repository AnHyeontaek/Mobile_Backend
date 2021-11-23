package com.catchb.web.dto.images;

import com.catchb.domain.images.Images;
import lombok.Getter;

@Getter
public class ImagesResponseDto {
    private Long image_id;
    private String image_route;
    private String image_address;
    private String start_time;
    private String end_time;
    private String image_name;

    public ImagesResponseDto(Images entity){
        this.image_id = entity.getImage_id();
        this.image_route = entity.getImage_route();
        this.image_address = entity.getImage_address();
        this.start_time = entity.getStart_time();
        this.end_time = entity.getEnd_time();
        this.image_name = entity.getImage_name();
    }
}
