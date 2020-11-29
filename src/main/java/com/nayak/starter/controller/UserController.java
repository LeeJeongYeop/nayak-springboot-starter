package com.nayak.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.nayak.starter.domain.User;
import com.nayak.starter.domain.UserRepository;
import com.nayak.starter.dto.request.SignInRequest;
import com.nayak.starter.dto.request.SignUpRequest;
import com.nayak.starter.dto.response.UserInfoResponse;
import com.nayak.starter.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/")
    public Iterable<User> get() {
        return userRepository.findAll();
    }

    @PostMapping("/sign-up")
    public UserInfoResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest);
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestBody SignInRequest signInRequest) {
        return userService.signIn(signInRequest);
    }
}
