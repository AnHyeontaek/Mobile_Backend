package com.catchb.web.controller.images;

import com.catchb.web.dto.images.ImagesResponseDto;
import com.catchb.web.dto.images.ImagesSaveRequestDto;
import com.catchb.service.images.ImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/images")
public class ImagesAPIController {
    private final ImagesService imagesService;

    @PostMapping
    public Long save(@RequestBody ImagesSaveRequestDto requestDto){
        return imagesService.save(requestDto);
    }

    @GetMapping(value = "/{image_id}")
    public ImagesResponseDto findById(@PathVariable Long image_id){
        return imagesService.findById(image_id);
    }

    @GetMapping(value = "/address/{image_address}")
    public List<ImagesResponseDto> findByAddress(@PathVariable String image_address){
        return imagesService.findByAddress(image_address);
    }
}
