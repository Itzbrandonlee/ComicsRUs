package com.techelevator.model;

public class Collection {

    public int collectionId;
    public String collectionName;
    public int userId;
    public String collectionPrivacy;

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCollectionPrivacy() {
        return collectionPrivacy;
    }

    public void setCollectionPrivacy(String collectionPrivacy) {
        this.collectionPrivacy = collectionPrivacy;
    }

    public Collection(int collectionId, String collectionName, int userId, String collectionPrivacy) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.userId = userId;
        this.collectionPrivacy = collectionPrivacy;
    }

    public Collection(){}

    @Override
    public String toString() {
        return "collections{" +
                ", collection_id='" + collectionId + '\'' +
                ", collection_name=" + collectionName +
                ", user_id=" + userId +
                ", collection_privacy=" + collectionPrivacy +
                '}';
    }

}
