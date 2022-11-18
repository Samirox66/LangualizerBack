package com.example.LangualizerBack.model;

import com.example.LangualizerBack.entity.DeckEntity;

import java.util.ArrayList;

public class Deck {
    private ArrayList<ArrayList<Lang>> phrases;

    private String id;

    private String name;

    private Boolean published;

    public ArrayList<ArrayList<Lang>> getPhrases() {
        return phrases;
    }

    public void setPhrases(ArrayList<ArrayList<Lang>> phrases) {
        this.phrases = phrases;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getName() {
        return name;
    }

    public Boolean getPublished() {
        return published;
    }

    public Deck() {}

    public Deck(ArrayList<ArrayList<Lang>> phrases, String name, Boolean published, String id) {
        this.phrases = phrases;
        this.name = name;
        this.published = published;
        this.id = id;
    }

    public static ArrayList<Deck> toModel(ArrayList<DeckEntity> deckEntities) {
        ArrayList<Deck> decks = new ArrayList<>();
        for (DeckEntity deck : deckEntities) {
            decks.add(new Deck(deck.getPhrases(), deck.getName(), deck.getPublished(), deck.getId()));
        }

        return decks;
    }
}
