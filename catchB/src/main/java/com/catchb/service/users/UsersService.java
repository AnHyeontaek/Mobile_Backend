package com.catchb.service.users;

import com.catchb.domain.users.Users;
import com.catchb.domain.users.UsersRepository;
import com.catchb.web.dto.users.UsersResponseDto;
import com.catchb.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto){
        return usersRepository.save(requestDto.toEntity()).getUser_num();
    }

    public UsersResponseDto findById(Long user_num){
        Users entity = usersRepository.findById(user_num)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디의 사용자를 찾지 못함. user_id =" + user_num));

        return new UsersResponseDto(entity);
    }

    public List<UsersResponseDto> findByUserid(String user_id){
        return usersRepository.findByUserid(user_id)
                .stream().map(UsersResponseDto::new)
                .collect(Collectors.toList());
    }

}
