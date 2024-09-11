package edu.eazybank.spring_security.controller;

import edu.eazybank.spring_security.entity.CardEntity;
import edu.eazybank.spring_security.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardRepository cardsRepository;

    @GetMapping("/myCards")
    public List<CardEntity> getCardDetails(@RequestParam long id) {
        List<CardEntity> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }
}
