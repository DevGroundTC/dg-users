package com.example.dgusers.dto;

import com.example.dgusers.database.entity.EducationLevel;
import com.example.dgusers.database.entity.MarriedStatus;
import com.example.dgusers.database.entity.Sex;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserCreateEditDtoRequest {

    Long requestId;
    Long userProfileId;
    String nickname;
    String firstname;
    String lastname;
    String location;
    String birthPlace;
    LocalDateTime birthDate;
    Sex sex;
    LocalDateTime created;
    MarriedStatus marriedStatus;
    EducationLevel educationLevel;
}
