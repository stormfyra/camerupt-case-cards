package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CardCollection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RequestMapping(path = "/collections")
@RestController
public class CollectionController {
    private final CollectionDao collectionDao;

    public CollectionController(CollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CardCollection> getCardCollections(Principal principal) {
        String username = principal.getName();
        return collectionDao.getCardCollections(username);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Object getCollectionById(Principal principal, @PathVariable int id) {
        String username;
        if (principal == null) {
            username = "";
        } else {
            username = principal.getName();
        }
        CardCollection cardCollection = collectionDao.getCardCollectionById(id, username);
        if (cardCollection == null) {
            return new ResponseEntity<String>("The collection you are trying to view either does not exist or is private.", HttpStatus.FORBIDDEN);
        } else {
            return cardCollection;
        }
    }
}
