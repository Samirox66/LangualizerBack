package com.example.LangualizerBack.repository;

import com.example.LangualizerBack.entity.DeckEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface DeckRepository extends MongoRepository<DeckEntity, String> {
    public DeckEntity findByEmailAndName(String email, String name);
    public DeckEntity findByName(String name);
    public ArrayList<DeckEntity> findAllByEmail(String email);
    public ArrayList<DeckEntity> findAllByPublished(Boolean published);
}
