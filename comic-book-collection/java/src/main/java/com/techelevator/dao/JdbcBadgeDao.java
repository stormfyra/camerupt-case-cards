package com.techelevator.dao;

import com.techelevator.model.Badge;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JdbcRowSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBadgeDao implements BadgeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBadgeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Badge> getUserBadges(int id) {
        List<Badge> badges = new ArrayList<>();

        String sqlQuery = "SELECT badge_name FROM badges_user_has\n" +
                        "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, id);

        while (results.next()){
            Badge badge = mapRowToBadge(results);
            badges.add(badge);
        }

        return badges;
    }

    @Override
    public void giveUserBadge(int id, Badge badge) {

    }

    private Badge mapRowToBadge(SqlRowSet results) {
        return new Badge(results.getString("badge_name"));
    }
}
