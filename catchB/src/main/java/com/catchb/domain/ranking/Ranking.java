package com.catchb.domain.ranking;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Ranking {
    @Id // 랭킹 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ranking_num;

    // 랭킹 유저 이름
    @Column(nullable = false)
    private String ranking_name;

    // 랭킹 유저 크레딧
    @Column(nullable = false)
    private int ranking_credit;

    @Builder
    public Ranking(String ranking_name, int ranking_credit){
        this.ranking_name = ranking_name;
        this.ranking_credit = ranking_credit;
    }
}
