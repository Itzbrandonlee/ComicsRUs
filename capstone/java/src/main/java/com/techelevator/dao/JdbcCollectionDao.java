package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.MarvelComic;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createCollection(Collection newCollection) {

        String sql = "INSERT INTO collections (collection_id, collection_name, user_id, collection_privacy) " +
                "values(DEFAULT, ?, ?, ?);";
        try {
            jdbcTemplate.update(sql, newCollection.getCollectionName(), newCollection.getUserId(), newCollection.getCollectionPrivacy());
        }
        catch (Error e) {
            System.out.println("This did not work");
        }
    }



    @Override
    public List<Collection> getCollectionById(int collectionId) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id, collection_privacy FROM collections WHERE collection_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionId);

        try {
            while (result.next()) {
                Collection collection = mapRowToCollection(result);
                collections.add(collection);
            }
        }
        catch (DataAccessException e) {
            System.out.println("Error accessing data");
        }
        return collections;
    }

    @Override
    public List<Collection> getAllCollections() {

        List<Collection> collections= new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id, collection_privacy FROM collections";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        try {
            while (result.next()) {
                Collection collection = mapRowToCollection(result);
                collections.add(collection);
            }
        }
        catch (DataAccessException e) {
            System.out.println("Error accessing data.");
        }

        return collections;
    }

    @Override
    public List<Collection> getCollectionsByUser(int userId) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name, user_id, collection_privacy FROM collections WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        try {
            while (result.next()) {
                Collection collection = mapRowToCollection(result);
                collections.add(collection);
            }
        }
        catch (DataAccessException e) {
            System.out.println("Error accessing data");
        }
        return collections;
    }





    private Collection mapRowToCollection(SqlRowSet rs) {
        Collection collection = new Collection();
        collection.setCollectionId(rs.getInt("collection_id"));
        collection.setCollectionName(rs.getString("collection_name"));
        collection.setUserId(rs.getInt("user_id"));
        collection.setCollectionPrivacy(rs.getString("collection_privacy"));
        return collection;
    }

}
