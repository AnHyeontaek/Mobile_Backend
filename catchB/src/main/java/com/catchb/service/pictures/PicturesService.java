package com.catchb.service.pictures;

import com.catchb.domain.pictures.Pictures;
import com.catchb.domain.pictures.PicturesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

//    public Pictures readpictures(String pictures_loc, String pictures_name, String pictures_path){
//        return picturesRepository.save
//    }

}
