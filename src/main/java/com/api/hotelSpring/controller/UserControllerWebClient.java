package com.api.hotelSpring.controller;


import com.api.hotelSpring.model.UserModel;
import com.api.hotelSpring.service.UserServiceWebCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserControllerWebClient {
    private final UserServiceWebCliente userService;

    @GetMapping("/{username}")
    public UserModel getUser (@PathVariable String username) throws ClassNotFoundException{
        return userService.getUser(username);
    }
}
