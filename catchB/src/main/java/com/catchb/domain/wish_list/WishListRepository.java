package com.catchb.domain.wish_list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

    //@Query(nativeQuery = true, value = "SELECT * FROM images WHERE image_address=:address")
    //List<Images> findByAddress(@Param("address") String image_address);
}