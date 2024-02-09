package com.example.dgusers.service;

import com.example.dgusers.database.repository.UserRepository;
import com.example.dgusers.dto.UserReadDtoRequest;
import com.example.dgusers.mapper.UserReadMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.example.dgusers.util.TestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserReadMapper userReadMapper;
    @InjectMocks
    private UserService userService;


    @Test
    void findByIdWhenUserFound() {
        var user = getUser();
        var userReadDtoRequest = getExistedUserReadDtoRequest();

        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));
        when(userReadMapper.map(user)).thenReturn(getUserReadDto());

        var actualResult = userService.findById(userReadDtoRequest);
        var excpectedResult = userReadMapper.map(user);
        assertEquals(excpectedResult, actualResult);
    }

    @Test
    void findByIdWhenUserNotFound() {
        var userReadDtoRequest = new UserReadDtoRequest(
                REQUEST_ID,
                NOT_FOUND_USER_ID
        );
        var exception = assertThrows(NoSuchElementException.class, () -> userService.findById(userReadDtoRequest));
        assertThat(exception.getMessage()).isEqualTo("User with ID: "+ NOT_FOUND_USER_ID + " not found");
    }

    private UserReadDtoRequest getExistedUserReadDtoRequest() {
        return new UserReadDtoRequest(
                REQUEST_ID,
                USER_ID
        );
    }
}