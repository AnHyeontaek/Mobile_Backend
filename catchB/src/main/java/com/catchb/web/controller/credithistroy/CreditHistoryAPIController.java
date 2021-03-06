package com.catchb.web.controller.credithistroy;


import com.catchb.service.credithistory.CreditHistoryService;
import com.catchb.web.dto.credithistory.CreditHistoryRequestDto;
import com.catchb.web.dto.credithistory.CreditHistoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/credithistory")
public class CreditHistoryAPIController {
    private final CreditHistoryService creditHistoryService;

    @PostMapping
    public CreditHistoryResponseDto save(@RequestBody CreditHistoryRequestDto requestDto){
        return creditHistoryService.save(requestDto);
    }

    @GetMapping(value = "/{user_id}")
    public List<CreditHistoryResponseDto> findcredithistory(@PathVariable String user_id){
        return creditHistoryService.findcredithistory(user_id);
    }

}
