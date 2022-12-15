package com.techelevator.controller;

import com.techelevator.model.MarvelComic;
import com.techelevator.service.MarvelComicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MarvelComicController {

        String API_BASE_URL = "http://gateway.marvel.com/v1/public";

        private MarvelComicService marvelComicService;

    public MarvelComicController(MarvelComicService marvelComicService) {
        this.marvelComicService = marvelComicService;
    }

    @RequestMapping(path="/comics", method= RequestMethod.GET)
    public List<MarvelComic> getAllComics(){
        return marvelComicService.getAllComics();
    }

    @RequestMapping(path="/comic/bytitle/{title}", method=RequestMethod.GET)
    public List <MarvelComic> getComicByTitle(@PathVariable String title){
        return marvelComicService.getComicByTitle(title);
    }

    @RequestMapping(path="/characters/id/{characterName}", method=RequestMethod.GET)
    public int getCharacterIdByName(@PathVariable String characterName) {
        return marvelComicService.getCharacterIdByName(characterName);
    }

    @RequestMapping(path="/comic/creator/{creatorName}", method=RequestMethod.GET )
    public List<MarvelComic> getComicByCreatorName(@PathVariable String creatorName) {
            return marvelComicService.getComicByCreatorName(creatorName);
    }

    @RequestMapping(path="/comic/series/{seriesName}", method=RequestMethod.GET)
    public List<MarvelComic> getComicBySeriesName(@PathVariable String seriesName){
        return marvelComicService.getComicBySeriesName(seriesName);
    }

    @RequestMapping(path="/creatorId/{creatorName}", method=RequestMethod.GET)
    public int getCreatorIdByName(@PathVariable String creatorName){
        return marvelComicService.getCreatorIdByName(creatorName);
    }

    @RequestMapping(path = "/comic/idhelp/{title}", method = RequestMethod.GET)
    public int getComicIdByTitle(@PathVariable String comicTitle){
        return marvelComicService.getComicIdByTitle(comicTitle);
    }

    //TODO add requestmapping and method for comicIdByTitle
}
