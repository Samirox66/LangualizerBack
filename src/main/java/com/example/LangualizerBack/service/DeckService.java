package com.example.LangualizerBack.service;

import com.example.LangualizerBack.entity.DeckEntity;
import com.example.LangualizerBack.model.Deck;
import com.example.LangualizerBack.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;

    public ArrayList<Deck> getDecks(String email) {
        ArrayList<DeckEntity> decks = deckRepository.findAllByEmail(email);
        return Deck.toModel(decks);
    }

    public void save(ArrayList<DeckEntity> deckEntities) {
        String email = deckEntities.get(0).getEmail();
        for (DeckEntity deck : deckEntities) {
            DeckEntity tmp = deckRepository.findByEmailAndName(email, deck.getName());
            if (tmp != null) {
                deckRepository.deleteById(tmp.getId());
            }
            deckRepository.save(deck);
        }
    }

    public void publishDeck(String email, String deckName) throws Exception {
        DeckEntity publishingDeck = deckRepository.findByEmailAndName(email, deckName);
        if (publishingDeck == null) {
            throw new Exception("No such deck");
        }
        if (publishingDeck.getPublished()) {
            throw new Exception("Deck has already been published");
        }
        publishingDeck.setPublished(true);
        deckRepository.deleteById(publishingDeck.getId());
        deckRepository.save(publishingDeck);
    }

    public ArrayList<DeckEntity> getPublishedDecks() {
        return deckRepository.findAllByPublished(true);
    }
}
