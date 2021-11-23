package com.catchb.domain.recently_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentlyPostRepository extends JpaRepository<RecentlyPost, Long> {
    //@Query(nativeQuery = true, value = "SELECT * FROM images WHERE image_address=:address")
    //List<Images> findByAddress(@Param("address") String image_address);
}
