package com.catchb.domain.credit_history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditHistoryRepository extends JpaRepository<CreditHistory, Long> {

    //@Query(nativeQuery = true, value = "SELECT * FROM images WHERE image_address=:address")
    //List<Images> findByAddress(@Param("address") String image_address);
}
