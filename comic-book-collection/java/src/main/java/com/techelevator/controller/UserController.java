package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Authority;
import com.techelevator.model.ProfileDto;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userDao.getUserById(id);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            user.setShippingAddress(null);
            user.setEmail(null);
            user.setAuthorities((Set<Authority>) null);
            user.setFullName(null);
        }
        return users;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @RequestMapping(value = "/update-profile", method = RequestMethod.PUT)
    public void updateUserProfile(@RequestBody ProfileDto user) {
        userDao.updateUserProfile(user.getEmail(), user.getFullName(), user.getShippingAddress(), user.getBio(),
                Math.toIntExact(user.getId()), user.getProfilePokemon());
        System.out.println(user);
    }
}
