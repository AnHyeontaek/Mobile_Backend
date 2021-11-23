package com.catchb.web.controller.ranking;

import com.catchb.service.ranking.RankingService;
import com.catchb.web.dto.ranking.RankingRequestDto;
import com.catchb.web.dto.ranking.RankingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/ranking")
public class RankingAPIController {
    private final RankingService rankingService;

    @PostMapping
    public Long save(@RequestBody RankingRequestDto requestDto){
        return rankingService.save(requestDto);
    }

    @GetMapping(value = "/{ranking_num}")
    public RankingResponseDto findById(@PathVariable Long ranking_num){
        return rankingService.findById(ranking_num);
    }

//    @GetMapping(value = "/address/{image_address}")
//    public List<ImagesResponseDto> findByAddress(@PathVariable String image_address){
//        return imagesService.findByAddress(image_address);
//    }
}
