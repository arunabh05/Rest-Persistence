package com.cmpe275.controller;

import com.cmpe275.domain.Address;
import com.cmpe275.domain.Sponsor;
import com.cmpe275.service.SponsorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 * SponsorController to perform CRUD opertions on {@link Sponsor}
 */

@RestController
@Api(value = "Sponsor management endpoint", description = "This API performs CRUD operations on Sponsoor.")
@RequestMapping(value = "/sponsor")
public class SponsorController {

    private final SponsorService sponsorService;

    /**
     * Instantiates a new SponsorController
     *
     * @param sponsorService        {@link SponsorService} to perform actions on sponsor object
     */
    @Autowired
    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    /**
     * Creates a new {@link Sponsor}
     *
     * @param name              Name of the sponsor
     * @param description       Description about the sponsor
     * @param city              City of the sponsor address
     * @param street            Street name and number of the sponsor address
     * @param state             State of the sponsor address
     * @param zip               Zip Code of the sponsor address
     *
     * @return A {@link Sponsor} object on success, or HttpStatus.BAD_REQUEST on invalid request
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestParam(value = "name") String name, @RequestParam(value = "description",
            required = false) String description, @RequestParam(value = "city", required = false) String city,
                          @RequestParam(value = "street", required = false) String street,
                          @RequestParam(value = "state", required = false) String state,
                          @RequestParam(value = "zip", required = false) Integer zip) {

        Address address = new Address(city, street, state, zip);
        Sponsor sponsor = new Sponsor(name, description, address);

        sponsor = sponsorService.create(sponsor);
        if(sponsor == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(sponsor, HttpStatus.OK);
    }

    /**
     * Gets a {@link Sponsor}
     *
     * @param id         Id of the sponsor
     *
     * @return The requested {@link Sponsor} object on success, or a HttpStatus.NOT_FOUND if sponsor doesn't exists
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Long id){

        Sponsor sponsor = sponsorService.get(id);
        if(sponsor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(sponsor, HttpStatus.OK);
    }

    /**
     * Updates a {@link Sponsor}
     *
     * @param id                Id of the sponsor
     * @param name              Name of the sponsor
     * @param description       Description about the sponsor
     * @param city              City of the sponsor address
     * @param street            Street name and number of the sponsor address
     * @param state             State of the sponsor address
     * @param zip               Zip Code of the sponsor address
     *
     * @return The updated {@link Sponsor} object on success, or HttpStatus.NOT_FOUND if sponsor doesn't exists or
     * HttpStatus.BAD_REQUEST on invalid request
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestParam(value = "name") String name,
                          @RequestParam(value = "description", required = false) String description,
                          @RequestParam(value = "city", required = false) String city,
                          @RequestParam(value = "street", required = false) String street,
                          @RequestParam(value = "state", required = false) String state,
                          @RequestParam(value = "zip", required = false) Integer zip) {

        Sponsor sponsor = sponsorService.get(id);
        if(sponsor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Address address = null;
        if(city != null || state != null || street != null || zip != null){
            address = new Address(city,street,state,zip);
        }

        Sponsor updatedSponsorInfo = new Sponsor(id ,name, description, address);
        sponsor = sponsorService.update(updatedSponsorInfo);
        if(sponsor == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(sponsor, HttpStatus.OK);
    }

    /**
     * Deletes a {@link Sponsor}
     *
     * @param id         Id of the sponsor
     *
     * @return The deleted {@link Sponsor} object on success, or HttpStatus.NOT_FOUND if sponsor doesn't exists or
     * HttpStatus.BAD_REQUEST on invalid request
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        Sponsor sponsor = sponsorService.get(id);
        if(sponsor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try{
            sponsorService.delete(id);
            return new ResponseEntity<Object>(sponsor, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
