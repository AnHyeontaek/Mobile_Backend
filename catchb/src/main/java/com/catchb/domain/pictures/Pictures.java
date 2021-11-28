package com.catchb.domain.pictures;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Pictures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pictures_num;

    @Column(nullable = false)
    private String pictures_loc;

    @Column(nullable = false)
    private String pictures_name;

    @Column(nullable = false)
    private String pictures_path;

    @Builder
    public Pictures(String pictures_loc, String pictures_name, String pictures_path) {
        this.pictures_loc = pictures_loc;
        this.pictures_name = pictures_name;
        this.pictures_path = pictures_path;
    }
}
