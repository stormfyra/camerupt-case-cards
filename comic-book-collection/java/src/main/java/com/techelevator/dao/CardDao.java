package com.techelevator.dao;

import com.techelevator.model.Card;

import java.util.List;

public interface CardDao {

    List<Card> getAllCards();
    Card getCardById(int id);

    void addCards(List<Card> cards, int collectionId);
}
