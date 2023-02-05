package com.techelevator.dao;

import com.techelevator.model.Badge;

import java.util.List;

public interface BadgeDao {

    List<Badge> getUserBadges(int id);

    void giveUserBadge(int id, Badge badge);

    List<Badge> getGivableBadges(int parseInt);
}
