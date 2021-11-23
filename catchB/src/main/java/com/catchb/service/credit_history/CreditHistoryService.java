package com.catchb.service.credit_history;

import com.catchb.domain.credit_history.CreditHistory;
import com.catchb.domain.credit_history.CreditHistoryRepository;
import com.catchb.web.dto.credit_history.CreditHistoryRequestDto;
import com.catchb.web.dto.credit_history.CreditHistoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreditHistoryService {
    private final CreditHistoryRepository creditHistoryRepository;

    @Transactional
    public Long save(CreditHistoryRequestDto requestDto){
        return creditHistoryRepository.save(requestDto.toEntity()).getCredit_num();
    }

    public CreditHistoryResponseDto findById(Long credit_num){
        CreditHistory entity = creditHistoryRepository.findById(credit_num)
                .orElseThrow(() -> new IllegalArgumentException("해당 크레딧 내역이 존재하지 않습니다. id =" + credit_num));

        return new CreditHistoryResponseDto(entity);
    }

//    public List<ImagesResponseDto> findByAddress(String image_address){
//        return imagesRepository.findByAddress(image_address)
//                .stream().map(ImagesResponseDto::new)
//                .collect(Collectors.toList());
//    }





}
