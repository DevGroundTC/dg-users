package com.example.dgusers.integration.http.controller;

import com.example.dgusers.dto.UserReadDtoRequest;
import com.example.dgusers.integration.IntegrationTestBase;
import com.example.dgusers.util.JacksonUtil;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserRestControllerTestIT extends IntegrationTestBase {

    private final static Long USER_ID = 10L;
    private final static Long USER_NOT_FOUND_ID = 100500L;
    private final static Long REQUEST_ID = 12345L;
    private final static String USERS_ULR = "/api/v1/users";

    private final MockMvc mockMvc;

    @Test
    public void findByIdWhenUserFound() throws Exception {

        String json = JacksonUtil.fromObjectToJson(new UserReadDtoRequest(REQUEST_ID, USER_ID));

        mockMvc.perform(post(USERS_ULR)
                        .contentType(MediaType.APPLICATION_JSON).characterEncoding(StandardCharsets.UTF_8)
                        .content(json))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void findByIdWhenUserNotFound() throws Exception {

        String json = JacksonUtil.fromObjectToJson(new UserReadDtoRequest(REQUEST_ID, USER_NOT_FOUND_ID));

        mockMvc.perform(post(USERS_ULR)
                        .contentType(MediaType.APPLICATION_JSON).characterEncoding(StandardCharsets.UTF_8)
                        .content(json))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}