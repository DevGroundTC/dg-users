package com.example.dgusers.util;

import com.example.dgusers.database.entity.EducationLevel;
import com.example.dgusers.database.entity.MarriedStatus;
import com.example.dgusers.database.entity.Sex;
import com.example.dgusers.database.entity.User;
import com.example.dgusers.dto.UserReadDtoResponse;

import java.time.LocalDateTime;

public class TestUtil {

    public static final Long USER_ID = 1L;
    public static final Long NOT_FOUND_USER_ID = 100500L;
    public static final Long REQUEST_ID = 100L;

    public static User getUser() {
        return User.builder()
                .id(USER_ID)
                .nickname("user")
                .firstname("Ivan")
                .lastname("Ivanov")
                .location("Pokrov")
                .birthPlace("Kovrov")
                .birthDate(LocalDateTime.of(1999, 10, 10, 6, 10))
                .sex(Sex.MALE)
                .created(LocalDateTime.of(2024, 2, 9, 10, 10))
                .marriedStatus(MarriedStatus.MARRIED)
                .educationLevel(EducationLevel.COLLEGE)
                .build();
    }

    public static UserReadDtoResponse getUserReadDto() {
        return UserReadDtoResponse.builder()
                .requestId(REQUEST_ID)
                .id(USER_ID)
                .nickname("user")
                .firstname("Ivan")
                .lastname("Ivanov")
                .location("Pokrov")
                .birthPlace("Kovrov")
                .birthDate(LocalDateTime.of(1999, 10, 10, 6, 10))
                .sex(Sex.MALE)
                .created(LocalDateTime.of(2024, 2, 9, 10, 10))
                .marriedStatus(MarriedStatus.MARRIED)
                .educationLevel(EducationLevel.COLLEGE)
                .build();
    }
}
