package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.CardCollection;
import com.techelevator.model.NewCollectionDTO;

import java.util.List;

public interface CollectionDao {
    List<CardCollection> getCardCollections(String username);
    CardCollection getCardCollectionById(int id, String username);
    boolean toggleCollectionPrivacyStatus(int id, String username, boolean privacy);
    void createNewCollection (NewCollectionDTO newCollection);
    void addCardToCollection(int id, Card card);
    void deleteCollection(int id, String username);
    void updateCollection(String name, int id, CardCollection collection);
}
