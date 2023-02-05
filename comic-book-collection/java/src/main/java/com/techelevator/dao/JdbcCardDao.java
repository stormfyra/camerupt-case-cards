package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.CardSet;
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
        String setIdsQuery = "SELECT id FROM set;";
        String addToCollectionQuery = "INSERT INTO collection_card (collection_id, card_id)\n" +
                "VALUES (?, ?)";

        SqlRowSet cardIdsResults = jdbcTemplate.queryForRowSet(cardIdsQuery);
        SqlRowSet setIdsResults = jdbcTemplate.queryForRowSet(setIdsQuery);

        Set<String> cardIds = new HashSet<>();
        Set<String> setIds = new HashSet<>();


        while (cardIdsResults.next()) {
            cardIds.add(cardIdsResults.getString("card_id"));
        }
        while (setIdsResults.next()) {
            setIds.add(setIdsResults.getString("id"));
        }


        for (Card card : cards) {
            if (!cardIds.contains(card.getId())) {
                String cardName = card.getName();
                String cardId = card.getId();
                String largeImage = card.getImages().getLarge();
                String smallImage = card.getImages().getSmall();
                String superType = card.getSupertype();
                int hp = card.getHp();
                String rarity = card.getRarity();
                List<String> subtypes = card.getSubtypes();
                List<String> types = card.getTypes();
                CardSet cardSet = card.getCardSet();

                addToSubtypes(subtypes);
                addToCardsets(cardSet);

                String sqlUpdateCard = "INSERT INTO card (card_id, name, large_image, small_image, super_type, hp, rarity)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?);";
                jdbcTemplate.update(sqlUpdateCard, cardId, cardName, largeImage, smallImage, superType, hp, rarity);

                String sqlUpdateCardSet = "INSERT INTO card_set (card_id, set_id) VALUES (?, ?);";
                jdbcTemplate.update(sqlUpdateCardSet, cardId, cardSet.getId());

                for (String type : types) {
                    String sqlUpdateCardType = "INSERT INTO card_type (card_id, type_id)\n" +
                        "VALUES (?, (SELECT id FROM type WHERE name = ?));";
                    jdbcTemplate.update(sqlUpdateCardType, cardId, type);
                }

                for (String subtype : subtypes) {
                    String sqlUpdateCardSubtype = "INSERT INTO card_subtype (card_id, subtype_id)\n" +
                            "VALUES (?, (SELECT id FROM subtype WHERE name = ?));";
                    jdbcTemplate.update(sqlUpdateCardSubtype, cardId, subtype);
                }

                jdbcTemplate.update(addToCollectionQuery, collectionId, cardId);
            }
        }
    }

    private void addToSubtypes(List<String> subtypes) {
        String subtypeIdsQuery = "SELECT name FROM subtype;";
        SqlRowSet subtypeNamesResults = jdbcTemplate.queryForRowSet(subtypeIdsQuery);
        Set<String> subtypeNames = new HashSet<>();
        while (subtypeNamesResults.next()) {
            subtypeNames.add(subtypeNamesResults.getString("name"));
        }
        for (String subtype : subtypes) {
            if (!subtypeNames.contains(subtype)) {
                String sqlQuery = "INSERT INTO subtype (name) VALUES (?);";
                jdbcTemplate.update(sqlQuery, subtype);
            }
        }
    }

    private void addToCardsets(CardSet cardSet) {
        String cardSetIdQuery = "SELECT id FROM set WHERE id = ?;";
        SqlRowSet cardSetIdResult = jdbcTemplate.queryForRowSet(cardSetIdQuery, cardSet.getId());
        if (!cardSetIdResult.next()) {
            String sqlQuery = "INSERT INTO set (id, name, series, printed_total, symbol_image, logo_image)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            jdbcTemplate.update(sqlQuery, cardSet.getId(), cardSet.getName(), cardSet.getSeries(),
                    cardSet.getPrintedTotal(), cardSet.getImages().getSymbol(), cardSet.getImages().getLogo());
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
