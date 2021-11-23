package com.catchb.service.images;

import com.catchb.domain.images.Images;
import com.catchb.domain.images.ImagesRepository;
import com.catchb.web.dto.images.ImagesResponseDto;
import com.catchb.web.dto.images.ImagesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImagesService {
    private final ImagesRepository imagesRepository;

    @Transactional
    public Long save(ImagesSaveRequestDto requestDto){
        return imagesRepository.save(requestDto.toEntity()).getImage_id();
    }

    public ImagesResponseDto findById(Long image_id){
        Images entity = imagesRepository.findById(image_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사진이 존재하지 않습니다. id =" + image_id));

        return new ImagesResponseDto(entity);
    }

    public List<ImagesResponseDto> findByAddress(String image_address){
        return imagesRepository.findByAddress(image_address)
                .stream().map(ImagesResponseDto::new)
                .collect(Collectors.toList());
    }

}
