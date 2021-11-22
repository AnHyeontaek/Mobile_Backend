package com.catchb.web.controller.users;


import com.catchb.service.users.UsersService;
import com.catchb.web.dto.users.UsersResponseDto;
import com.catchb.web.dto.users.UsersSaveRequestDto;
import com.catchb.web.dto.users.UsersResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/users")
public class UsersAPIController {
    private final UsersService usersService;

    @PostMapping
    public UsersResponseDto save(@RequestBody UsersSaveRequestDto requestDto){
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

    @GetMapping(value = "/user_info")
    public List<UsersResponseDto> findUser(){
        return usersService.getUsers();
    }

    //로그인 요청
    @RequestMapping(value= "/test", method = {RequestMethod.GET})
    public UsersResultDto LoginPage(@RequestParam(value="user_id") String userId, @RequestParam(value="user_pw") String userPw){

        return usersService.LoginUser(userId, userPw);
    }

    //비밀번호 변경전 사용자 정보 확인 요청
    @RequestMapping(value= "/change", method = {RequestMethod.GET})
    public UsersResultDto ChangePW(@RequestParam(value="user_id") String userId, @RequestParam(value="user_phone") String userPh){

        return usersService.ChangePw(userId, userPh);
    }


//    @RequestMapping(value ="update")
//    public UsersResponseDto CPW(@RequestParam(value="user_id") String userId,@RequestParam(value="user_pw") String userPw){
//        String a = usersService.findByUserid(userId);
//
//        return usersService.checkPh(userPw);
//    }

}
