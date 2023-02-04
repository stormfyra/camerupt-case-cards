package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Images;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JdbcCardDao implements CardDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Card> getAllCards() {
        String sqlQuery = "SELECT * FROM card";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);

        List<Card> allCards = new ArrayList<>();

        while(results.next()) {
            Card card = mapRowToCard(results);
            allCards.add(card);
        }

        return allCards;
    }

    @Override
    public Card getCardById(int id) {
        return null;
    }

    @Override
    public void addCards(List<Card> cards, int collectionId) {
        String cardIdsQuery = "SELECT card_id FROM card;";
        String addToCollectionQuery = "INSERT INTO collection_card (collection_id, card_id)\n" +
                "VALUES (?, ?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(cardIdsQuery);
        Set<String> cardIds = new HashSet<>();
        while (results.next()) {
            cardIds.add(results.getString("card_id"));
        }
        for (Card card: cards) {
            if (!cardIds.contains(card.getId())) {
                String cardName = card.getName();
                String cardId = card.getId();
                String largeImage = card.getImages().getLarge();
                String smallImage = card.getImages().getSmall();
                String sqlUpdateCard = "INSERT INTO CARD (card_id, name, large_image, small_image)\n" +
                        "VALUES (?, ?, ?, ?);";
                jdbcTemplate.update(sqlUpdateCard, cardId, cardName, largeImage, smallImage);
            }
            jdbcTemplate.update(addToCollectionQuery, collectionId, card.getId());
        }
    }

    private Card mapRowToCard(SqlRowSet results) {
        Card card = new Card();
        Images externalApiCardImagesDto = new Images();
        card.setId(results.getString("card_id"));
        card.setName(results.getString("name"));
        externalApiCardImagesDto.setLarge(results.getString("large_image"));
        externalApiCardImagesDto.setSmall(results.getString("small_image"));
        card.setImages(externalApiCardImagesDto);
        return card;
    }
}
