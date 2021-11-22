package com.catchb.service.users;

import com.catchb.domain.users.Users;
import com.catchb.domain.users.UsersRepository;
import com.catchb.web.dto.users.UsersResponseDto;
import com.catchb.web.dto.users.UsersResultDto;
import com.catchb.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    @Transactional
    public UsersResponseDto save(UsersSaveRequestDto requestDto){
        System.out.println("성공");
        return new UsersResponseDto(usersRepository.save(requestDto.toEntity()));
    }

//    public Long save(UsersSaveRequestDto requestDto){
//        System.out.println("성공");
//        return usersRepository.save(requestDto.toEntity()).getUser_num();
//    }

    public UsersResponseDto findById(Long user_num){
        Users entity = usersRepository.findById(user_num)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾지 못함. user_id =" + user_num));

        return new UsersResponseDto(entity);
    }

    public List<UsersResponseDto> findByUserid(String user_id){
        return usersRepository.findByUserid(user_id)
                .stream().map(UsersResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<UsersResponseDto> getUsers() {
        return usersRepository.findAll()
                .stream().map(UsersResponseDto::new)
                .collect(Collectors.toList());
    }
    //LoginUser
    public UsersResultDto LoginUser(String id, String pw){
        String user_pw = usersRepository.findPw(id);
        String result = "";
        if (user_pw==null) {
            result = "0"; //일치하는 아이디가 없습니다
            return new UsersResultDto(result);
        }
        if (pw.equals(user_pw)) {
            result = "1"; //로그인 성공
        }
        else {
            result = "2"; //비밀번호가 틀립니다
        }
        return new UsersResultDto(result);
    }

    //LoginUser
    public UsersResultDto ChangePw(String id, String ph){
        String user_ph = usersRepository.findPh(id);
        String result = "";
        if (user_ph==null) {
            result = "0"; //일치하는 아이디가 없습니다
            return new UsersResultDto(result);
        }
        if (ph.equals(user_ph)) {
            result = "1"; //사용자 정보 조회 성공
        }
        else {
            result = "2"; //핸드폰번호가 틀립니다
        }
        return new UsersResultDto(result);
    }


    public UsersResultDto checkPh(String id){
        String user_pw = usersRepository.updatePw(id);
        String result = user_pw;
        return new UsersResultDto(result);

   }
}
