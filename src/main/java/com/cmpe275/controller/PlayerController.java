package com.cmpe275.controller;

import com.cmpe275.domain.Address;
import com.cmpe275.domain.Player;
import com.cmpe275.domain.Sponsor;
import com.cmpe275.service.PlayerService;
import com.cmpe275.service.SponsorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 * Player Controller to perform CRUD operations on Player
 */


@RestController
@Api(value = "Player management endpoint", description = "This API performs CRUD operations on Players.")
@RequestMapping(value = "/player")
public class PlayerController {

    private final PlayerService playerService;
    private final SponsorService sponsorService;

    /**
     * Instantiates a new PlayerController
     *
     * @param playerService         Player Service to perform actions on player object
     * @param sponsorService        Sponsor Service to perform actions on sponsor object
     */
    @Autowired
    public PlayerController(PlayerService playerService, SponsorService sponsorService) {
        this.playerService = playerService;
        this.sponsorService = sponsorService;
    }


    /**
     * Creates a new Player
     *
     * @param firstname         First name of the player
     * @param lastname          Last name of the player
     * @param email             Email address of the player
     * @param description       Description about the player
     * @param city              City of the player address
     * @param street            Street name and number of the player address
     * @param state             State of the player address
     * @param zip               Zip Code of the player address
     * @param sponsorId         Sponsor id of the sponsor
     *
     * @return A {@link Player} object on success, or a HttpStatus.BAD_REQUEST on invalid request
     *
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestParam(value = "firstname") String firstname, @RequestParam(value = "lastname")
            String lastname, @RequestParam(value = "email") String email,
                                 @RequestParam(value = "description", required = false) String description,
                                 @RequestParam(value = "city", required = false) String city,
                                 @RequestParam(value = "street", required = false) String street,
                                 @RequestParam(value = "state", required = false) String state,
                                 @RequestParam(value = "zip", required = false) Integer zip,
                                 @RequestParam(value = "sponsor", required = false) Long sponsorId) {

        Address address = null ;
        Sponsor sponsor = null;

        if(city != null || state != null || street != null || zip != null){
            address = new Address(city,street,state,zip);
        }

        if(sponsorId != null){
            sponsor = sponsorService.get(sponsorId);

            if(sponsor == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        Player player = new Player(firstname, lastname, email, description, address, sponsor);
        player = playerService.create(player);

        if(player == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(player, HttpStatus.OK);
    }

    /**
     * Gets a Player
     *
     * @param id         Id of the player
     *
     * @return A {@link Player} object on success, or a HttpStatus.NOT_FOUND if player doesn't exists
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Long id){

        Player player = playerService.get(id);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(player, HttpStatus.OK);
    }

    /**
     * Updates a Player
     *
     * @param id                Id of the player
     * @param firstname         First name of the player
     * @param lastname          Last name of the player
     * @param email             Email address of the player
     * @param description       Description about the player
     * @param city              City of the player address
     * @param street            Street name and number of the player address
     * @param state             State of the player address
     * @param zip               Zip Code of the player address
     * @param sponsorId         Sponsor id of the sponsor
     *
     * @return A {@link Player} object on success, or HttpStatus.NOT_FOUND if player doesn't exists or
     * HttpStatus.BAD_REQUEST on invalid request
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestParam(value = "firstname") String firstname,
                         @RequestParam(value = "lastname") String lastname, @RequestParam(value = "email") String email,
                         @RequestParam(value = "description", required = false) String description,
                         @RequestParam(value = "city", required = false) String city,
                         @RequestParam(value = "street", required = false) String street,
                         @RequestParam(value = "state", required = false) String state,
                         @RequestParam(value = "zip", required = false) Integer zip,
                         @RequestParam(value = "sponsor", required = false) Long sponsorId) {

        Player player = playerService.get(id);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Address address = null;
        Sponsor sponsor = null;

        if(city != null || state != null || street != null || zip != null){
            address = new Address(city,street,state,zip);
        }

        if(sponsorId != null){
            sponsor = sponsorService.get(sponsorId);
            if(sponsor == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        Player newPlayerInfo = new Player(id, firstname, lastname, email,description, address, sponsor);
        player = playerService.update(newPlayerInfo);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(player, HttpStatus.OK);
    }

    /**
     * Deletes a player
     *
     * @param id         Id of the player
     *
     * @return A {@link Player} object on success, or HttpStatus.NOT_FOUND if player doesn't exists or
     * HttpStatus.BAD_REQUEST on invalid request
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        Player player = playerService.get(id);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            playerService.delete(id);
            return new ResponseEntity<Object>(player, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}