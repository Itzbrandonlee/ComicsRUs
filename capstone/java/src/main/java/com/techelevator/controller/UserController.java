package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/users")
public class UserController {
    private UserDao dao;

    public UserController(UserDao dao) {
        this.dao = dao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<User> viewAllUsers (){
        return dao.findAll();
    }

}
