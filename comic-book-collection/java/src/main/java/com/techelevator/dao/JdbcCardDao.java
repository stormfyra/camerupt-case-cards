package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Images;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public void addACard(Card card) {
        
    }

    private Card mapRowToCard(SqlRowSet results) {
        Card card = new Card();
        Images externalApiCardImagesDto = new Images();
        card.setId(results.getString("card_id"));
        card.setCardName(results.getString("name"));
        externalApiCardImagesDto.setLarge(results.getString("large_image"));
        externalApiCardImagesDto.setSmall(results.getString("small_image"));
        card.setImages(externalApiCardImagesDto);
        return card;
    }
}
