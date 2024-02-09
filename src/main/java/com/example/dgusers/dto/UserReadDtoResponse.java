package com.example.dgusers.dto;

import com.example.dgusers.database.entity.EducationLevel;
import com.example.dgusers.database.entity.MarriedStatus;
import com.example.dgusers.database.entity.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserReadDtoResponse {
    private Long requestId;
    private Long id;
    private String nickname;
    private String firstname;
    private String lastname;
    private String location;
    private String birthPlace;
    private LocalDateTime birthDate;
    private Sex sex;
    private LocalDateTime created;
    private LocalDateTime modified;
    private MarriedStatus marriedStatus;
    private EducationLevel educationLevel;
}
