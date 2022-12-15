//package com.techelevator.service;
//
//import com.techelevator.model.Collection;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class CollectionService {
//    public String authToken = null;
//    public static final String API_BASE_URL = "http://localhost:9000/collections/";
//    private RestTemplate restTemplate = new RestTemplate();
//
//    public Collection[] getAllCollections() {
//        Collection[] collections = null;
//        ResponseEntity<Collection[]> response =
//                restTemplate.exchange(API_BASE_URL + "all", HttpMethod.GET, Collection[].class);
//        collections = response.getBody();
//
//        return collections;
//    }
//    private HttpEntity<Void> makeAuthEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//    }
//}
