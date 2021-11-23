package com.catchb.web.dto.ranking;

import com.catchb.domain.ranking.Ranking;
import com.catchb.domain.recently_post.RecentlyPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class RankingRequestDto {
    private String ranking_name;
    private int ranking_credit;

    @Builder
    public RankingRequestDto(String ranking_name, int ranking_credit){
        this.ranking_name = ranking_name;
        this.ranking_credit = ranking_credit;
    }
    public Ranking toEntity() {
        return Ranking.builder()
                .ranking_name(ranking_name)
                .ranking_credit(ranking_credit)
                .build();
    }
}
