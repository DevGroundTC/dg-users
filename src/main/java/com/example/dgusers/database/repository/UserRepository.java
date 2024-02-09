package com.example.dgusers.database.repository;

import com.example.dgusers.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
