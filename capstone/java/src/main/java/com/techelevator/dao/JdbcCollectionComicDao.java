package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.CollectionComic;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCollectionComicDao implements CollectionComicDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionComicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addComicToCollection(CollectionComic collectionComic, int collectionId){
        String sql = "INSERT INTO collections_comic (collection_id, collection_comic_id, marvel_id, comic_title, description, imageurl, creator_id) VALUES (?, DEFAULT, ?, ?, ?, ?, ?);";
        try {
            jdbcTemplate.update(sql, collectionId, collectionComic.getMarvelId(), collectionComic.getComicTitle(), collectionComic.getDescription(), collectionComic.getImageURL(), collectionComic.getCreatorId());
        }
        catch (Error e) {
            System.out.println("An error has occurred.");
        }
    }

    @Override
    public List<CollectionComic> countYourCollection(int userId) {
        List<CollectionComic> collectionComic = new ArrayList<>();
        String sql = "SELECT *  " +
                "FROM collections_comic cc " +
                "JOIN collections c ON c.collection_id=cc.collection_id " +
                "Where user_id = ?;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
            while (result.next()){
                CollectionComic collection = mapRowToCollectionComic(result);
                collectionComic.add(collection);
            }
        }
        catch (Error e) {
            e.getMessage();
        }
        return collectionComic;
    }

    @Override
    public List<CollectionComic> getAllComicsByCollectionId(int collectionId) {
        List<CollectionComic> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_comic_id, marvel_id, comic_title, description, imageurl, creator_id FROM collections_comic WHERE collection_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionId);

        try {
            while (result.next()) {
                CollectionComic collectionComic = mapRowToCollectionComic(result);
                collections.add(collectionComic);
            }
        }
        catch (DataAccessException e) {
            System.out.println("Error accessing data");
        }
        return collections;
    }

    private CollectionComic mapRowToCollectionComic(SqlRowSet rs) {
        CollectionComic collectionComic = new CollectionComic();
        collectionComic.setCollectionId(rs.getInt("collection_id"));
        collectionComic.setCollectionComicId(rs.getInt("collection_comic_id"));
        collectionComic.setMarvelId(rs.getInt("marvel_id"));
        collectionComic.setComicTitle(rs.getString("comic_title"));
        collectionComic.setDescription(rs.getString("description"));
        collectionComic.setImageURL(rs.getString("imageurl"));
        collectionComic.setCreatorId(rs.getInt("creator_id"));
        return collectionComic;
    }
}
