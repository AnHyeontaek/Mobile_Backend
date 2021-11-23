package com.catchb.web.dto.recently_post;

import com.catchb.domain.recently_post.RecentlyPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class RecentlyPostResponseDto {
    private Long recently_num;
    private String recently_name;
    private String recently_date;
    private String recently_hashtag;
    private String recently_image;

    public RecentlyPostResponseDto(RecentlyPost entitiy){
        this.recently_num = entitiy.getRecently_num();
        this.recently_name = entitiy.getRecently_name();
        this.recently_date = entitiy.getRecently_date();
        this.recently_hashtag = entitiy.getRecently_hashtag();
        this.recently_image = entitiy.getRecently_image();
    }

}
