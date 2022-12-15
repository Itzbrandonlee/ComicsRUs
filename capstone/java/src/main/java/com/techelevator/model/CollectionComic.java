package com.techelevator.model;

public class CollectionComic {
    private int collectionId;
    private String comicTitle;
    private int collectionComicId;
    private int marvelId;
    private String description;
    private String imageURL;
    private int creatorId;

    public CollectionComic(){}

    public CollectionComic(int collectionId, String comicTitle, int collectionComicId, int marvelId, String description, String imageURL, int creatorId) {
        this.collectionId = collectionId;
        this.comicTitle = comicTitle;
        this.collectionComicId = collectionComicId;
        this.marvelId = marvelId;
        this.description = description;
        this.imageURL = imageURL;
        this.creatorId = creatorId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle;
    }

    public int getCollectionComicId() {
        return collectionComicId;
    }

    public void setCollectionComicId(int collectionComicId) {
        this.collectionComicId = collectionComicId;
    }

    public int getMarvelId() {
        return marvelId;
    }

    public void setMarvelId(int marvelId) {
        this.marvelId = marvelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
}
