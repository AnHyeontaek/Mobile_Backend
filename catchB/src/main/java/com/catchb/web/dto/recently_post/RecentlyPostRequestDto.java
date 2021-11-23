package com.catchb.web.dto.recently_post;

import com.catchb.domain.recently_post.RecentlyPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecentlyPostRequestDto {
    private String recently_name;
    private String recently_date;
    private String recently_hashtag;
    private String recently_image;

    @Builder
    public RecentlyPostRequestDto(String recently_name, String recently_date, String recently_hashtag, String recently_image){
        this.recently_name = recently_name;
        this.recently_date = recently_date;
        this.recently_hashtag = recently_hashtag;
        this.recently_image = recently_image;
    }
    public RecentlyPost toEntity() {
        return RecentlyPost.builder()
                .recently_name(recently_name)
                .recently_date(recently_date)
                .recently_hashtag(recently_hashtag)
                .recently_image(recently_image)
                .build();
    }
}
