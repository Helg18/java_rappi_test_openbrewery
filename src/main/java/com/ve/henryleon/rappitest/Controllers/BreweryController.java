package com.ve.henryleon.rappitest.Controllers;

import com.ve.henryleon.rappitest.Models.Brewery;
import com.ve.henryleon.rappitest.Services.BreweryRequesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@EnableAutoConfiguration
public class BreweryController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BreweryRequesterService breweryRequesterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(Model model) {
        List<Brewery> breweryList = breweryRequesterService.getBreweries();

        model.addAttribute("breweries", breweryList);
        return "Home";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String Details(Model model, @PathVariable Integer id) {
        Brewery brewery = breweryRequesterService.getBrewery(id);

        model.addAttribute("brewery", brewery);
        return "Details";
    }

}
