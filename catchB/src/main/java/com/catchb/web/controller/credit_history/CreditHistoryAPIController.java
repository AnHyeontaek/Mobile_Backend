package com.catchb.web.controller.credit_history;

import com.catchb.domain.credit_history.CreditHistory;
import com.catchb.service.credit_history.CreditHistoryService;
import com.catchb.web.dto.credit_history.CreditHistoryRequestDto;
import com.catchb.web.dto.credit_history.CreditHistoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/credit_history")
public class CreditHistoryAPIController {
    private final CreditHistoryService creditHistoryService;

    @PostMapping
    public Long save(@RequestBody CreditHistoryRequestDto requestDto){
        return creditHistoryService.save(requestDto);
    }

    @GetMapping(value = "/{credit_num}")
    public CreditHistoryResponseDto findById(@PathVariable Long credit_num){
        return creditHistoryService.findById(credit_num);
    }

//    @GetMapping(value = "/address/{image_address}")
//    public List<ImagesResponseDto> findByAddress(@PathVariable String image_address){
//        return imagesService.findByAddress(image_address);
//    }
}
