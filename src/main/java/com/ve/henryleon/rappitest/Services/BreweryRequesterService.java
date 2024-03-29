package com.ve.henryleon.rappitest.Services;

import com.ve.henryleon.rappitest.Models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BreweryRequesterService {

    @Autowired
    private RestTemplate restTemplate;

    private String URL_BASE = "https://api.openbrewerydb.org/breweries/";
    private String URL_BY_NAME = "https://api.openbrewerydb.org/breweries?by_name=";

    public List<Brewery> getBreweries ()
    {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<Brewery[]> breweries = restTemplate.exchange(this.URL_BASE, HttpMethod.GET, entity, Brewery[].class);

            return Arrays.asList(breweries.getBody());
        } catch (Exception ex) {
            System.out.println("An Error has been occurred.");
            ex.printStackTrace();
            return null;
        }
    }

    public Brewery getBrewery ( int id )
    {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<Brewery> brewery = restTemplate.exchange(this.URL_BASE + id, HttpMethod.GET, entity, Brewery.class);

            return brewery.getBody();
        } catch (Exception ex) {
            System.out.println("An Error has been occurred.");
            ex.printStackTrace();
        }
        return null;
    }

    public List<Brewery> getBreweryByName(String name) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<Brewery[]> breweries = restTemplate.exchange(this.URL_BY_NAME + name, HttpMethod.GET, entity, Brewery[].class);

            return Arrays.asList(breweries.getBody());
        } catch (Exception ex) {
            System.out.println("An Error has been occurred.");
            ex.printStackTrace();
            return null;
        }
    }
}
