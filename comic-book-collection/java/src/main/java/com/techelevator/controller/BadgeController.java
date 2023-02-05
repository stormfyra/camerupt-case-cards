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
    public List<Badge> getUserBadges (@PathVariable int id) {
        return badgeDao.getUserBadges(id);
    }

    @RequestMapping (path = "/{id}/GiveBadge", method = RequestMethod.POST)
    public void giveBadgeToUser (@PathVariable int id, @RequestBody Badge badge) {
        badgeDao.giveUserBadge(id, badge);
    }

    @RequestMapping (path = "/give/{id}", method = RequestMethod.GET)
    public List<Badge> getGivableBadges (@PathVariable int id){
       return badgeDao.getGivableBadges(id);
    }


}
