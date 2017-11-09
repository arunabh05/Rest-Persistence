package com.cmpe275.controller;

import com.cmpe275.domain.Address;
import com.cmpe275.domain.Sponsor;
import com.cmpe275.service.SponsorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 */

@RestController
@Api(value = "Sponsor management endpoint", description = "This API performs CRUD operations on Sponsoor.")
@RequestMapping(value = "/api/v1/sponsor")
public class SponsorController {

    private final SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @PostMapping
    public Sponsor create(@RequestParam(value = "name") String name, @RequestParam(value = "description",
            required = false) String description, @RequestParam(value = "city", required = false) String city,
                          @RequestParam(value = "street", required = false) String street,
                          @RequestParam(value = "state", required = false) String state,
                          @RequestParam(value = "zip", required = false) Integer zip) {


        Address address = new Address(city,street , state, zip);
        Sponsor sponsor = new Sponsor(name, description, address);

        return sponsorService.create(sponsor);
    }


    @GetMapping(value = "/{id}")
    public Sponsor get(@PathVariable(value = "id") Long id){

        Sponsor sponsor = sponsorService.get(id);
        return sponsor;
    }

    @PutMapping(value = "/{id}")
    public Sponsor update(){
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public Sponsor delete(){
        return null;
    }
}
