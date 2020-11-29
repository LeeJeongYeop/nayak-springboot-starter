package com.nayak.starter.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.nayak.starter.auth.JwtTokenProvider;
import com.nayak.starter.domain.User;
import com.nayak.starter.domain.UserRepository;
import com.nayak.starter.dto.request.SignInRequest;
import com.nayak.starter.dto.request.SignUpRequest;
import com.nayak.starter.dto.response.UserInfoResponse;
import com.nayak.starter.mapper.user.UserMapper;
import com.nayak.starter.utils.SecurityUtils;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public UserInfoResponse signUp(SignUpRequest request) {
        return UserMapper.INSTANCE.toUserInfoResponse(userRepository.save(User.builder()
            .email(request.getEmail())
            .password(SecurityUtils.passwordEncode(request.getPassword()))
            .role(request.getRole())
            .name(request.getName())
            .build()
        ));
    }

    public String signIn(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

        if (!SecurityUtils.passwordMatch(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return jwtTokenProvider.createToken(user.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
