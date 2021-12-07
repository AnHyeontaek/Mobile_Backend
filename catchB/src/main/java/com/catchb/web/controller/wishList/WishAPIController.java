package com.catchb.web.controller.wishList;

import com.catchb.service.wishList.WishService;
import com.catchb.web.dto.wishList.WishRequestDto;
import com.catchb.web.dto.wishList.WishResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/wishlist")
public class WishAPIController {
    private final WishService wishService;

    @PostMapping
    public WishResponseDto save(@RequestBody WishRequestDto requestDto){
        return wishService.save(requestDto);
    }

    @GetMapping(value = "/{user_id}/{image_id}")
    public List<WishResponseDto> findByWishId(@PathVariable String user_id, @PathVariable Long image_id){
        return wishService.findByWishId(user_id, image_id);
    }

    @DeleteMapping("/delete/{user_id}/{image_id}")
    public void delete(@PathVariable("user_id")String user_id, @PathVariable("image_id") Long image_id){
        wishService.deleteWish(user_id, image_id);
    }

    @GetMapping("/{user_id}")
    public List<WishResponseDto> findByImageid(@PathVariable("user_id")String user_id){
        return wishService.findByImageid(user_id);
    }
}
