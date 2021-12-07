package com.catchb.service.wishList;

import com.catchb.domain.wishList.WishRepository;
import com.catchb.web.dto.wishList.WishRequestDto;
import com.catchb.web.dto.wishList.WishResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WishService {
    private final WishRepository wishRepository;

    @Transactional
    public WishResponseDto save(WishRequestDto requestDto){
        return new WishResponseDto(wishRepository.save(requestDto.toEntity()));
    }

    public List<WishResponseDto> findByWishId(String user_id, Long image_id){
        return wishRepository.findByWish(user_id, image_id)
                .stream().map(WishResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void deleteWish(String user_id, Long image_id){
        wishRepository.deleteWish(user_id, image_id);
    }

    public List<WishResponseDto> findByImageid(String user_id){
        return wishRepository.findByImageid(user_id)
                .stream().map(WishResponseDto::new)
                .collect(Collectors.toList());
    }
}
