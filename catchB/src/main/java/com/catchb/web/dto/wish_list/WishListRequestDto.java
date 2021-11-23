package com.catchb.web.dto.wish_list;

import com.catchb.domain.wish_list.WishList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class WishListRequestDto {
    private String wish_name;
    private String wish_date;
    private String wish_hashtag;
    private String wish_image;

    @Builder
    public WishListRequestDto(String wish_name, String wish_date, String wish_hashtag, String wish_image){
        this.wish_name = wish_name;
        this.wish_date = wish_date;
        this.wish_hashtag = wish_hashtag;
        this.wish_image = wish_image;
    }
    public WishList toEntity() {
        return WishList.builder()
                .wish_name(wish_name)
                .wish_date(wish_date)
                .wish_hashtag(wish_hashtag)
                .wish_image(wish_image)
                .build();
    }
}
