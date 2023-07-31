package com.example.prog4.mapper;

import com.example.prog4.controller.viewModel.User;
import com.example.prog4.model.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class UserMapper {

    public Users toUserModel(User user){
        return Users.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

}
