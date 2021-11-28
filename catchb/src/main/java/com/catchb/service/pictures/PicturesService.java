package com.catchb.service.pictures;

import com.catchb.domain.pictures.Pictures;
import com.catchb.domain.pictures.PicturesRepository;
import com.catchb.web.dto.pictures.PicturesResponsDto;
import com.catchb.web.dto.pictures.PicturesResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PicturesService {
    //레포지토리 저장하기
    private final PicturesRepository picturesRepository;
    private Pictures pictures;

    @Transactional
    public Pictures save(String pictures_loc, String pictures_name, String pictures_path){
        System.out.println("기릿!");
        pictures = new Pictures(pictures_loc, pictures_name, pictures_path);
        return picturesRepository.save(pictures);
    }

    public List<PicturesResponsDto> findByPicturesLoc(String pictures_loc){
        return picturesRepository.findByPicturesLoc(pictures_loc)
                .stream().map(PicturesResponsDto::new)
                .collect(Collectors.toList());
    }

    public PicturesResultDto Ppath(String pictures_loc){
        String pictures_path = picturesRepository.findpath(pictures_loc);
        String result = pictures_path;
        return new PicturesResultDto(result);
    }

}
