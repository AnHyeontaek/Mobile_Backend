package com.catchb.service.recently_post;

import com.catchb.domain.recently_post.RecentlyPost;
import com.catchb.domain.recently_post.RecentlyPostRepository;
import com.catchb.domain.wish_list.WishList;
import com.catchb.web.dto.recently_post.RecentlyPostRequestDto;
import com.catchb.web.dto.recently_post.RecentlyPostResponseDto;
import com.catchb.web.dto.wish_list.WishListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RecentlyPostService {

    private final RecentlyPostRepository recentlyPostRepository;

    @Transactional
    public Long save(RecentlyPostRequestDto requestDto){
        return recentlyPostRepository.save(requestDto.toEntity()).getRecently_num();
    }

    public RecentlyPostResponseDto findById(Long recently_num){
        RecentlyPost entity = recentlyPostRepository.findById(recently_num)
                .orElseThrow(() -> new IllegalArgumentException("해당 최근 본 게시글이 존재하지 않습니다. id =" + recently_num));

        return new RecentlyPostResponseDto(entity);
    }

//    public List<ImagesResponseDto> findByAddress(String image_address){
//        return imagesRepository.findByAddress(image_address)
//                .stream().map(ImagesResponseDto::new)
//                .collect(Collectors.toList());
//    }
}
