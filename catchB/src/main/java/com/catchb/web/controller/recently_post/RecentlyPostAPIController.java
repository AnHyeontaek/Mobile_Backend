package com.catchb.web.controller.recently_post;

import com.catchb.service.recently_post.RecentlyPostService;
import com.catchb.web.dto.recently_post.RecentlyPostRequestDto;
import com.catchb.web.dto.recently_post.RecentlyPostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/recently_post")
public class RecentlyPostAPIController {
    private final RecentlyPostService recentlyPostService;

    @PostMapping
    public Long save(@RequestBody RecentlyPostRequestDto requestDto){
        return recentlyPostService.save(requestDto);
    }

    @GetMapping(value = "/{recently_num}")
    public RecentlyPostResponseDto findById(@PathVariable Long recently_num){
        return recentlyPostService.findById(recently_num);
    }

//    @GetMapping(value = "/address/{image_address}")
//    public List<ImagesResponseDto> findByAddress(@PathVariable String image_address){
//        return imagesService.findByAddress(image_address);
//    }
}
