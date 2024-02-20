package com.example.dgusers.mapper;

import com.example.dgusers.database.entity.User;
import com.example.dgusers.dto.UserCreateEditDtoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDtoRequest, User> {
    @Override
    public User map(UserCreateEditDtoRequest userCreateEditDtoRequest) {
        User user = new User();
        copy(userCreateEditDtoRequest, user);
        return user;
    }

    @Override
    public User map(UserCreateEditDtoRequest fromObject, User toObject) {
        copy(fromObject, toObject);
        toObject.setModified(LocalDateTime.now());
        return toObject;
    }

    private void copy(UserCreateEditDtoRequest dto, User user) {
        user.setNickname(dto.getNickname());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setLocation(dto.getLocation());
        user.setBirthPlace(dto.getBirthPlace());
        user.setBirthDate(dto.getBirthDate());
        user.setSex(dto.getSex());
        user.setCreated(dto.getCreated());
        user.setMarriedStatus(dto.getMarriedStatus());
        user.setEducationLevel(dto.getEducationLevel());
    }
}
