package com.example.dgusers.service;

import com.example.dgusers.database.repository.UserRepository;
import com.example.dgusers.dto.UserCreateEditDtoRequest;
import com.example.dgusers.dto.UserReadDtoRequest;
import com.example.dgusers.dto.UserReadDtoResponse;
import com.example.dgusers.mapper.UserCreateEditMapper;
import com.example.dgusers.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public UserReadDtoResponse findById(UserReadDtoRequest userReadDtoRequest) {
        var userId = userReadDtoRequest.getUserId();
        var userReadDtoResponse = userRepository.findById(userId)
                .map(userReadMapper::map)
                .orElseThrow(() -> new NoSuchElementException("User with ID: " + userId + " not found"));
        userReadDtoResponse.setRequestId(userReadDtoRequest.getRequestId());
        return userReadDtoResponse;
    }

    @Transactional
    public ResponseEntity<UserReadDtoResponse> create(UserCreateEditDtoRequest userCreateEditDtoRequest) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        UserReadDtoResponse userReadDtoResponse;
        if (userCreateEditDtoRequest.getUserProfileId() != null) {
            log.info("Update user profile");
            httpStatus = HttpStatus.OK;
            userReadDtoResponse = userRepository.findById(userCreateEditDtoRequest.getUserProfileId())
                    .map(entity -> userCreateEditMapper.map(userCreateEditDtoRequest, entity))
                    .map(userRepository::saveAndFlush)
                    .map(userReadMapper::map)
                    .orElseThrow();
        } else {
            log.info("Create new user profile");
            userReadDtoResponse = Optional.of(userCreateEditDtoRequest)
                    .map(userCreateEditMapper::map)
                    .map(userRepository::save)
                    .map(userReadMapper::map)
                    .orElseThrow();
        }
        userReadDtoResponse.setRequestId(userCreateEditDtoRequest.getRequestId());
        return ResponseEntity
                .status(httpStatus)
                .body(userReadDtoResponse);
    }
}
