package com.example.LangualizerBack.controller;

import com.example.LangualizerBack.entity.DeckEntity;
import com.example.LangualizerBack.model.Deck;
import com.example.LangualizerBack.service.DeckService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
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

    @DeleteMapping("/delete/{email}/{deckName}")
    ResponseEntity deleteDeck(@PathVariable String email, @PathVariable String deckName) {
        try {
            deckService.deleteDeck(email, deckName);
            return ResponseEntity.ok("Deck " + deckName + " was deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/publish/{email}/{deckName}")
    ResponseEntity publishDeck(@PathVariable String email, @PathVariable String deckName) {
        try {
            deckService.publishDeck(email, deckName);
            return ResponseEntity.ok("Deck " + deckName + " was published");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/sharedDecks")
    ResponseEntity getPublishedDecks() {
        try {
            ArrayList<DeckEntity> publishedDecks = deckService.getPublishedDecks();
            return ResponseEntity.ok(publishedDecks);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
