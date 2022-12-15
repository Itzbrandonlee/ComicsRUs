package com.techelevator.controller;

import com.techelevator.dao.CollectionComicDao;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionComic;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/collections/")
public class CollectionComicController {
    private CollectionComicDao dao;

    public CollectionComicController(CollectionComicDao dao) {
        this.dao = dao;
    }

    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/{collectionId}/addComic/", method = RequestMethod.POST)
    public void addComicToCollection(@Valid @RequestBody CollectionComic newCollectionComic, @PathVariable int collectionId) {
        dao.addComicToCollection(newCollectionComic, collectionId);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "comics/{collectionId}", method = RequestMethod.GET)
    public List<CollectionComic> viewComicsByCollectionId (@PathVariable int collectionId) {
        return dao.getAllComicsByCollectionId(collectionId);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "count/{userId}", method = RequestMethod.GET)
    public List<CollectionComic> countYourComics (@PathVariable int userId) {
        return dao.countYourCollection(userId);
    }
}
