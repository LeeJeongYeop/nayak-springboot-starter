package com.nayak.starter.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nayak.starter.domain.User;
import com.nayak.starter.dto.response.UserInfoResponse;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserInfoResponse toUserInfoResponse(User user);
}
