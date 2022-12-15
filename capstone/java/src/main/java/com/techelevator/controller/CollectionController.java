package com.techelevator.controller;
import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.JdbcCollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Collection;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.techelevator.dao.CollectionDao;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.Connection;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/collections/")

public class CollectionController {
    private CollectionDao dao;

    public CollectionController(CollectionDao dao ) {this.dao = dao;}

    @PreAuthorize("permitAll")
    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Collection> viewAllCollections (){
        return dao.getAllCollections();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "{collectionId}", method = RequestMethod.GET)
    public List<Collection> viewCollectionsById (@RequestBody @PathVariable int collectionId) {
        return dao.getCollectionById(collectionId);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "user/{userId}", method = RequestMethod.GET)
    public List<Collection> viewCollectionsByUserId (@PathVariable int userId, Principal principal){
        return dao.getCollectionsByUser(userId);
    }


    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "new", method = RequestMethod.POST)
    public void createCollection(@Valid @RequestBody Collection newCollection) {
        dao.createCollection(newCollection);
    }

    
    }

