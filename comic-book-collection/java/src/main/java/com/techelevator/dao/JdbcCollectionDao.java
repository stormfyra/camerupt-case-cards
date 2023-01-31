package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.CardCollection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CardCollection> getCardCollections(String username) {
        List<CardCollection> cardCollections = new ArrayList<>();
        String sqlQuery = "SELECT collection_id, name, description, is_private, username FROM collection\n" +
                "JOIN users ON collection.user_id = users.user_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
        while (results.next()) {
            CardCollection cardCollection = mapRowToCardCollection(results);
            if (!cardCollection.isPrivate() || cardCollection.getOwnerUsername().equals(username)) {
                cardCollections.add(cardCollection);
            }
        }
        return cardCollections;
    }

    @Override
    public CardCollection getCardCollectionById(int id, String username) {
        CardCollection cardCollection = null;
        List<Card> cards = new ArrayList<>();
        String queryForCollectionDetails = "SELECT collection_id, name, description, is_private, username FROM collection\n" +
                "JOIN users ON collection.user_id = users.user_id\n" +
                "WHERE collection_id = ?;";
        String queryForCards = "SELECT card.name AS name, large_image, small_image\n" +
                "FROM collection\n" +
                "JOIN collection_card ON collection.collection_id = collection_card.collection_id\n" +
                "JOIN card ON collection_card.card_id = card.card_id\n" +
                "WHERE collection.collection_id = ?;";
        SqlRowSet collectionDetailsResults = jdbcTemplate.queryForRowSet(queryForCollectionDetails, id);
        if (collectionDetailsResults.next()) {
            cardCollection = mapRowToCardCollection(collectionDetailsResults);
        }
        SqlRowSet cardsResults = jdbcTemplate.queryForRowSet(queryForCards, id);
        while (cardsResults.next()) {
            cards.add(mapRowToCard(cardsResults));
        }
        cardCollection.setCards(cards);
        if (!cardCollection.isPrivate() || cardCollection.getOwnerUsername().equals(username)) {
            return cardCollection;
        } else {
            return null;
        }
    }

    private CardCollection mapRowToCardCollection(SqlRowSet results) {
        CardCollection cardCollection = new CardCollection();
        cardCollection.setCollectionId(results.getInt("collection_id"));
        cardCollection.setTitle(results.getString("name"));
        cardCollection.setOwnerUsername(results.getString("username"));
        cardCollection.setDescription(results.getString("description"));
        cardCollection.setPrivate(results.getBoolean("is_private"));
        return cardCollection;
    }

    private Card mapRowToCard(SqlRowSet results) {
        Card card = new Card();
        card.setCardName(results.getString("name"));
        card.setLargeImage(results.getString("large_image"));
        card.setSmallImage(results.getString("small_image"));
        return card;
    }
}
