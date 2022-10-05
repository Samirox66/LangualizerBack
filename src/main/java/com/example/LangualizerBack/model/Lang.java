package com.example.LangualizerBack.model;

public class Lang {
    private String language;
    private String text;

    private Integer key;

    Lang() {}

    Lang(String language, String text, Integer key) {
        this.language = language;
        this.text = text;
        this.key = key;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

    public Integer getKey() {
        return key;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
