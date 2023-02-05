package com.techelevator.controller;


import com.techelevator.dao.BadgeDao;
import com.techelevator.model.Badge;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/badges")
@RestController
@CrossOrigin
public class BadgeController {

    private final BadgeDao badgeDao;

    public BadgeController (BadgeDao badgedao) {
        this.badgeDao = badgedao;
    }

    @RequestMapping (path = "/{id}", method = RequestMethod.GET)
    public List<Badge> getUserBadges (@PathVariable String id) {
        return badgeDao.getUserBadges(((int)Integer.parseInt(id)));
    }

    @RequestMapping (path = "/{id}/GiveBadge", method = RequestMethod.POST)
    public void giveBadgeToUser (@PathVariable int id, @RequestBody Badge badge) {
        return badgeDao.giveUserBadge(id, badge);
    }

}
