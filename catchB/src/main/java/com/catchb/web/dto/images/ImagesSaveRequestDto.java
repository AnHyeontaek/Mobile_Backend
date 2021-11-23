package com.catchb.web.dto.images;

import com.catchb.domain.images.Images;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ImagesSaveRequestDto {
    private String image_route;
    private String image_address;
    private String start_time;
    private String end_time;
    private String image_name;

    @Builder
    public ImagesSaveRequestDto(String image_route, String image_address, String start_time, String end_time, String image_name){
        this.image_route = image_route;
        this.image_address = image_address;
        this.start_time = start_time;
        this.end_time = end_time;
        this.image_name = image_name;
    }
    public Images toEntity() {
        return Images.builder()
                .image_route(image_route)
                .image_address(image_address)
                .start_time(start_time)
                .end_time(end_time)
                .image_name(image_name)
                .build();
    }
}
