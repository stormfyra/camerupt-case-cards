package com.techelevator.controller;


import com.techelevator.dao.CardDao;
import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Card;
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
    List<Card> getAllCards() {
        return cardDao.getAllCards();
    }
}
