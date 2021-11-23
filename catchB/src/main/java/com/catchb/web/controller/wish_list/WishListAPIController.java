package com.catchb.web.controller.wish_list;


import com.catchb.service.wish_list.WishListService;
import com.catchb.web.dto.wish_list.WishListRequestDto;
import com.catchb.web.dto.wish_list.WishListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/wish_list")
public class WishListAPIController {
    private final WishListService wishListService;

    @PostMapping
    public Long save(@RequestBody WishListRequestDto requestDto){
        return wishListService.save(requestDto);
    }

    @GetMapping(value = "/{wish_num}")
    public WishListResponseDto findById(@PathVariable Long wish_num){
        return wishListService.findById(wish_num);
    }

//    @GetMapping(value = "/address/{image_address}")
//    public List<ImagesResponseDto> findByAddress(@PathVariable String image_address){
//        return imagesService.findByAddress(image_address);
//    }
}
