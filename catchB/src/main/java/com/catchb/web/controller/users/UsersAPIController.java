package com.catchb.web.controller.users;


import com.catchb.service.users.UsersService;
import com.catchb.web.dto.users.UsersResponseDto;
import com.catchb.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/users")
public class UsersAPIController {
    private final UsersService usersService;

    @PostMapping
    public Long save(@RequestBody UsersSaveRequestDto requestDto){
        return usersService.save(requestDto);
    }

    @GetMapping(value = "/{user_num}")
    public UsersResponseDto findById(@PathVariable Long user_num){
        return usersService.findById(user_num);
    }

    @GetMapping(value = "/user_id/{user_id}")
    public List<UsersResponseDto> findByUserid(@PathVariable String user_id){
        return usersService.findByUserid(user_id);
    }
}
