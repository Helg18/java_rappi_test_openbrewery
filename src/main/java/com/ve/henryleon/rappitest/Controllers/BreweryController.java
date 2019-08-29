package com.ve.henryleon.rappitest.Controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@EnableAutoConfiguration
public class BreweryController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home() {
        return "Home";
    }

}
