package com.catchb.domain.users;
import org.hibernate.service.spi.InjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    // 닉네임 sql 구문
    @Query(nativeQuery = true, value = "SELECT * FROM Users WHERE user_id =:id")
    List<Users> findByUserid(@Param("id") String user_id);

    // 패스워드 sql 구문
    @Query(nativeQuery = true, value = "SELECT user_pw FROM Users WHERE user_id =:id")
    String findPw(@Param("id") String user_id);


}
