package com.techelevator.dao;

import com.techelevator.model.MarvelComic;

import java.util.List;

public interface MarvelComicService {

    List<MarvelComic> getComicByCreatorName(String creatorName);

    List<MarvelComic> getComicByTitle(String title);

    List<MarvelComic> getComicBySeriesName(String seriesName);

    int getCharacterIdByName(String characterName);

    int getCreatorIdByName(String creatorName);

    String findCharacterOrCreatorId(String id, String jsonString, Integer offset);

    List<MarvelComic> getAllComics();

    String pathFinder(String pathKey, String comicJsonString, Integer offset);

    List<String> extractComicInfo(String comicJsonString);

    public List<MarvelComic> comicsJsonString(String listComicsJsonString, List<MarvelComic> listComics);
}
