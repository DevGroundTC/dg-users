package com.example.dgusers.integration.http.controller;

import com.example.dgusers.integration.IntegrationTestBase;
import com.example.dgusers.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class HealthCheckControllerTest extends IntegrationTestBase {

    private final MockMvc mockMvc;

    @Test
    public void shouldReturnOk () throws Exception {
        mockMvc.perform(get("/users/healthcheck"))
                .andExpect(jsonPath("$").value("OK"));
    }
}
