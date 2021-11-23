package com.catchb.web.dto.wish_list;

import com.catchb.domain.wish_list.WishList;
import lombok.Getter;

@Getter
public class WishListResponseDto {
    private Long wish_num;
    private String wish_name;
    private String wish_date;
    private String wish_hashtag;
    private String wish_image;

    public WishListResponseDto(WishList entitiy){
        this.wish_num = entitiy.getWish_num();
        this.wish_name = entitiy.getWish_name();
        this.wish_date = entitiy.getWish_date();
        this.wish_hashtag = entitiy.getWish_hashtag();
        this.wish_image = entitiy.getWish_image();
    }
}
