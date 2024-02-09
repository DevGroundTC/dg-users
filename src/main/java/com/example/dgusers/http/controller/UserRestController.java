package com.example.dgusers.http.controller;

import com.example.dgusers.dto.UserReadDtoRequest;
import com.example.dgusers.dto.UserReadDtoResponse;
import com.example.dgusers.service.UserService;
import com.example.dgusers.util.JacksonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserReadDtoResponse findById(@RequestBody UserReadDtoRequest userReadDtoRequest) {
        log.info("Exec findById. Incoming JSON: " + System.lineSeparator() + JacksonUtil.fromObjectToJson(userReadDtoRequest));
        var result = userService.findById(userReadDtoRequest);
        log.info("Returning JSON result: " + System.lineSeparator() + JacksonUtil.fromObjectToJson(result));
        return result;
    }
}
