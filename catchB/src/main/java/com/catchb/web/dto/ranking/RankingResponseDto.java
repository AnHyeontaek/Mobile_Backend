package com.catchb.web.dto.ranking;

import com.catchb.domain.ranking.Ranking;
import lombok.Getter;

@Getter
public class RankingResponseDto {
    private Long ranking_num;
    private String ranking_name;
    private int ranking_credit;

    public RankingResponseDto(Ranking entitiy){
        this.ranking_num = entitiy.getRanking_num();
        this.ranking_name = entitiy.getRanking_name();
        this.ranking_credit = entitiy.getRanking_credit();
    }
}
