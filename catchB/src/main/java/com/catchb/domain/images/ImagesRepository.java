package com.catchb.domain.images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM images WHERE image_address=:address")
    List<Images> findByAddress(@Param("address") String image_address);

}
