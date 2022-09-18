package com.example.LangualizerBack.model;

public class Lang {
    private String language;
    private String text;

    Lang() {}

    Lang(String language, String text) {
        this.language = language;
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setText(String text) {
        this.text = text;
    }
}
