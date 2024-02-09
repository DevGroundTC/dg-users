package com.example.dgusers.service;

import com.example.dgusers.database.repository.UserRepository;
import com.example.dgusers.dto.UserReadDtoRequest;
import com.example.dgusers.dto.UserReadDtoResponse;
import com.example.dgusers.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;

    public UserReadDtoResponse findById(UserReadDtoRequest userReadDtoRequest) {
        var userId = userReadDtoRequest.getUserId();
        var userReadDtoResponse =  userRepository.findById(userId)
                .map(userReadMapper::map)
                .orElseThrow(() -> new NoSuchElementException("User with ID: " + userId + " not found"));
        userReadDtoResponse.setRequestId(userReadDtoRequest.getRequestId());
        return userReadDtoResponse;
    }
}
