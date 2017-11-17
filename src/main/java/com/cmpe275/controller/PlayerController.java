package com.cmpe275.controller;

import com.cmpe275.domain.Address;
import com.cmpe275.domain.Player;
import com.cmpe275.domain.Sponsor;
import com.cmpe275.exceptions.BadRequestException;
import com.cmpe275.exceptions.ResourceNotFoundException;
import com.cmpe275.service.PlayerService;
import com.cmpe275.service.SponsorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by arunabh.shrivastava on 11/8/2017.
 */


@RestController
@Api(value = "Player management endpoint", description = "This API performs CRUD operations on Players.")
@RequestMapping(value = "/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;
    private final SponsorService sponsorService;

    @Autowired
    public PlayerController(PlayerService playerService, SponsorService sponsorService) {
        this.playerService = playerService;
        this.sponsorService = sponsorService;
    }

    @PostMapping
    public Player create(@RequestParam(value = "firstname") String firstname, @RequestParam(value = "lastname")
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
                throw new BadRequestException("Invalid Sponsor ID");
            }
        }

        Player player = new Player(firstname, lastname, email, description, address, sponsor);
        player = playerService.create(player);

        if(player == null){
            throw new BadRequestException("Bad Request");
        }

        return player;
    }

    @GetMapping(value = "/{id}")
    public Player get(@PathVariable(value = "id") Long id){

        Player player = playerService.get(id);
        if(player == null){
            throw new ResourceNotFoundException("Player not found");
        }
        return player;
    }

    @PutMapping(value = "/{id}")
    public Player update(@PathVariable("id") Long id, @RequestParam(value = "firstname") String firstname,
                         @RequestParam(value = "lastname") String lastname, @RequestParam(value = "email") String email,
                         @RequestParam(value = "description", required = false) String description,
                         @RequestParam(value = "city", required = false) String city,
                         @RequestParam(value = "street", required = false) String street,
                         @RequestParam(value = "state", required = false) String state,
                         @RequestParam(value = "zip", required = false) Integer zip,
                         @RequestParam(value = "sponsor", required = false) Long sponsorId) {

        Player player = playerService.get(id);
        if(player == null){
            throw new ResourceNotFoundException("Player not found");
        }

        Address address = null;
        Sponsor sponsor = null;

        if(city != null || state != null || street != null || zip != null){
            address = new Address(city,street,state,zip);
        }

        if(sponsorId != null){
            sponsor = sponsorService.get(sponsorId);
            if(sponsor == null){
                throw new BadRequestException("Invalid Sponsor ID");
            }
        }

        Player newPlayerInfo = new Player(id, firstname, lastname, email,description, address, sponsor);
        player = playerService.update(newPlayerInfo);
        if(player == null){
            throw new BadRequestException("Bad Request");
        }
        return player;
    }

    @DeleteMapping(value = "/{id}")
    public Player delete(@PathVariable("id") Long id){
        return playerService.delete(id);
    }
}