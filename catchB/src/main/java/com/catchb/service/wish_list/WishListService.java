package com.catchb.service.wish_list;

import com.catchb.domain.credit_history.CreditHistory;
import com.catchb.domain.wish_list.WishList;
import com.catchb.domain.wish_list.WishListRepository;
import com.catchb.web.dto.wish_list.WishListRequestDto;
import com.catchb.web.dto.wish_list.WishListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    @Transactional
    public Long save(WishListRequestDto requestDto){
        return wishListRepository.save(requestDto.toEntity()).getWish_num();
    }

    public WishListResponseDto findById(Long wish_num){
        WishList entity = wishListRepository.findById(wish_num)
                .orElseThrow(() -> new IllegalArgumentException("해당 찜목록이 존재하지 않습니다. id =" + wish_num));

        return new WishListResponseDto(entity);
    }

//    public List<ImagesResponseDto> findByAddress(String image_address){
//        return imagesRepository.findByAddress(image_address)
//                .stream().map(ImagesResponseDto::new)
//                .collect(Collectors.toList());
//    }
}
