package com.techelevator.dao;

import com.techelevator.model.CardCollection;
import java.util.List;

public interface CollectionDao {
    List<CardCollection> getCardCollections(String username);
    CardCollection getCardCollectionById(int id, String username);
    boolean toggleCollectionPrivacyStatus(int id, String username, boolean privacy);
}
