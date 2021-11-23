package com.catchb.domain.images;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    @Column(nullable = false)
    private String image_route;

    @Column(nullable = false)
    private String image_address;

    //제출 시작일
    @Column(columnDefinition = "DATE", nullable = false)
    private String start_time;

    //제출 마감일
    @Column(columnDefinition = "DATE", nullable = false)
    private String end_time;

    private String image_name;

    @Builder
    public Images(String image_route, String image_address, String start_time, String end_time, String image_name){
        this.image_route = image_route;
        this.image_address = image_address;
        this.start_time = start_time;
        this.end_time = end_time;
        this.image_name = image_name;
    }
}
