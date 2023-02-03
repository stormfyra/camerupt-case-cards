package com.techelevator.controller;


import com.techelevator.dao.CardDao;
import com.techelevator.model.Card;
import com.techelevator.model.ExternalApiCardDto;
import com.techelevator.model.Images;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/cards")
@RestController
@CrossOrigin
public class CardController {
    private final CardDao cardDao;

    public CardController(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @RequestMapping (path = "", method = RequestMethod.GET)
    public List<Card> getAllCards() {
        return cardDao.getAllCards();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void AddAllCards(@RequestBody List<ExternalApiCardDto> cards) {
        for (ExternalApiCardDto card : cards) {
            String name = card.getName();
            String id = card.getId();
            String smallImage = card.getImage().getSmall();
            String largeImage = card.getImage().getLarge();
            cardDao.addACard(new Card(id, name, new Images(largeImage, smallImage), 0));
        }
    }
}
