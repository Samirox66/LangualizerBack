package com.example.LangualizerBack.repository;

import com.example.LangualizerBack.entity.DeckEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface DeckRepository extends MongoRepository<DeckEntity, String> {
    public DeckEntity findByEmail(String email);
    public DeckEntity findByName(String name);
    public ArrayList<DeckEntity> findAllByEmail(String email);
}
