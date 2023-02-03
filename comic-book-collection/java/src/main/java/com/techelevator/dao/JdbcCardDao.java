package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.CardDTO;
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
        card.setCardId(results.getInt("card_id"));
        card.setCardName(results.getString("name"));
        card.setLargeImage(results.getString("large_image"));
        card.setSmallImage(results.getString("small_image"));
        return card;
    }
}
