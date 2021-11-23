package com.catchb.domain.recently_post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class RecentlyPost {
    @Id // 최근 본 게시물 목록 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recently_num;

    // 최근 본 게시물 이름
    @Column(nullable = false)
    private String recently_name;

    // 최근 본 날짜
    @Column(columnDefinition = "DATE", nullable = false)
    private String recently_date;

    // 최근 본 게시물 해시태그
    @Column(nullable = false)
    private String recently_hashtag;

    // 최근 본 게시물 이미지 경로
    @Column(nullable = false)
    private String recently_image;

    @Builder
    public RecentlyPost(String recently_name, String recently_date, String recently_hashtag, String recently_image){
        this.recently_name = recently_name;
        this.recently_date = recently_date;
        this.recently_hashtag = recently_hashtag;
        this.recently_image = recently_image;
    }
}
