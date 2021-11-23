package com.catchb.service.ranking;

import com.catchb.domain.ranking.Ranking;
import com.catchb.domain.ranking.RankingRepository;
import com.catchb.web.dto.ranking.RankingRequestDto;
import com.catchb.web.dto.ranking.RankingResponseDto;
import com.catchb.web.dto.recently_post.RecentlyPostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    @Transactional
    public Long save(RankingRequestDto requestDto){
        return rankingRepository.save(requestDto.toEntity()).getRanking_num();
    }

    public RankingResponseDto findById(Long ranking_num){
        Ranking entity = rankingRepository.findById(ranking_num)
                .orElseThrow(() -> new IllegalArgumentException("해당 랭킹이 존재하지 않습니다. id =" + ranking_num));

        return new RankingResponseDto(entity);
    }

//    public List<ImagesResponseDto> findByAddress(String image_address){
//        return imagesRepository.findByAddress(image_address)
//                .stream().map(ImagesResponseDto::new)
//                .collect(Collectors.toList());
//    }
}
