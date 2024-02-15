package com.example.dgusers.mapper;

import com.example.dgusers.database.entity.User;
import com.example.dgusers.dto.UserReadDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDtoResponse>{
    @Override
    public UserReadDtoResponse map(User user) {
        return UserReadDtoResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .location(user.getLocation())
                .birthPlace(user.getBirthPlace())
                .birthDate(user.getBirthDate())
                .sex(user.getSex())
                .created(user.getCreated())
                .modified(user.getModified())
                .marriedStatus(user.getMarriedStatus())
                .educationLevel(user.getEducationLevel())
                .build();
    }
}
