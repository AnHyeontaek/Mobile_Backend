package com.catchb.domain.pictures;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepository extends JpaRepository<Pictures, Long> {
    //다시 사진을 읽을 때에는 저장된 정보를 이용해 불러올 것이다.
    @Query(nativeQuery = true, value = "SELECT * FROM Pictures WHERE pictures_loc =:loc")
    List<Pictures> findByPicturesLoc(@Param("loc") String pictures_loc);

    @Query(nativeQuery = true, value = "SELECT pictures_path FROM Pictures WHERE pictures_loc=:loc")
    String findpath(@Param("loc") String pictures_loc);


}
