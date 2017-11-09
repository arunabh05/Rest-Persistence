package com.cmpe275.controller;

import com.cmpe275.domain.Address;
import com.cmpe275.domain.Player;
import com.cmpe275.domain.Sponsor;
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

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(description);
        System.out.println(sponsorId);

        Address address = new Address(city,street,state,zip);

        Sponsor sponsor = sponsorService.get(sponsorId);
        System.out.println("Sponsor Name:"+sponsor.getName());

        Player player = new Player(firstname, lastname, email, description, address ,sponsorId, sponsor);
        return playerService.create(player);
    }
}
