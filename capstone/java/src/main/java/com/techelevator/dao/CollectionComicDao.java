package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.CollectionComic;

import java.util.List;

public interface CollectionComicDao {

    void addComicToCollection(CollectionComic collectionComic, int collectionId);

    List<CollectionComic> getAllComicsByCollectionId(int collectionId);

    List<CollectionComic> countYourCollection(int userId);
}
