package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.sql.Connection;
import java.util.List;

public interface CollectionDao {

    void createCollection(Collection collection);

    List<Collection> getCollectionById(int collectionId);

    List<Collection> getAllCollections();

    List<Collection> getCollectionsByUser(int userId);






}
