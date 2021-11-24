package com.catchb.domain.pictures;

import com.catchb.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepository extends JpaRepository<Pictures, Long> {
    //다시 사진을 읽을 때에는 저장된 정보를 이용해 불러올 것이다.
    //List<Pictures> findAllByBoardIdx(Long pictures_num);

}
