package com.example.LangualizerBack.repository;

import com.example.LangualizerBack.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    public UserEntity findByEmail(String email);
    public List<UserEntity> findByUsername(String username);
}
