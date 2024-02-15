package com.example.dgusers.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String firstname;
    private String lastname;
    private String location;
    private String birthPlace;
    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private LocalDateTime created;
    private LocalDateTime modified;

    @Enumerated(EnumType.STRING)
    private MarriedStatus marriedStatus;

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
}
