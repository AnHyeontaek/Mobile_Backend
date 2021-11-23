package com.catchb.domain.wish_list;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class WishList {
    @Id // 찜 목록 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wish_num;

    // 찜한 게시물 이름
    @Column(nullable = false)
    private String wish_name;

    // 찜한 날짜
    @Column(columnDefinition = "DATE", nullable = false)
    private String wish_date;

    // 찜한 게시물 해시태그
    @Column(nullable = false)
    private String wish_hashtag;

    // 찜한 게시물 이미지 경로
    @Column(nullable = false)
    private String wish_image;

    @Builder
    public WishList(String wish_name, String wish_date, String wish_hashtag, String wish_image){
        this.wish_name = wish_name;
        this.wish_date = wish_date;
        this.wish_hashtag = wish_hashtag;
        this.wish_image = wish_image;
    }

}
