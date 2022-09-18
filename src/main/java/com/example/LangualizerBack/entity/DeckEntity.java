package com.example.LangualizerBack.entity;


import com.example.LangualizerBack.model.Lang;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class DeckEntity {

    @Id
    private String id;

    private String name;

    private String email;

    public Boolean published;

    private ArrayList<ArrayList<Lang>> phrases;

    public DeckEntity() {}

    public ArrayList<ArrayList<Lang>> getPhrases() {
        return phrases;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getPublished() {
        return published;
    }

    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setPhrases(ArrayList<ArrayList<Lang>> phrases) {
        this.phrases = phrases;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public void setName(String name) {
        this.name = name;
    }
}
