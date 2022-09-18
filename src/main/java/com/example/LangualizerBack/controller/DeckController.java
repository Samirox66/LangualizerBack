package com.example.LangualizerBack.controller;

import com.example.LangualizerBack.entity.DeckEntity;
import com.example.LangualizerBack.model.Deck;
import com.example.LangualizerBack.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RestController
@RequestMapping("/home")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping
    ResponseEntity getDecks(@RequestParam String email) {
        try {
            ArrayList<Deck> decks = deckService.getDecks(email);
            return ResponseEntity.ok(decks);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/save")
    ResponseEntity saveDecks(@RequestBody ArrayList<DeckEntity> deckEntities) {
        try {
            deckService.save(deckEntities);
            return ResponseEntity.ok("Decks were saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
