package com.cmpe275.controller;

import com.cmpe275.domain.Player;
import com.cmpe275.exceptions.BadRequestException;
import com.cmpe275.exceptions.ResourceNotFoundException;
import com.cmpe275.service.OpponentService;
import com.cmpe275.service.PlayerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */


@RestController
@Api(value = "Opponent management endpoint", description = "This API performs add and remove operations on Players to manage opponents.")
@RequestMapping(value = "/api/v1/opponents")
public class OpponentController {

    @Autowired
    PlayerService playerService;
    @Autowired
    OpponentService opponentService;

    @PutMapping(value = "/{id1}/{id2}")
    @ResponseStatus(HttpStatus.OK)
    public void add(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){

        Player player1 = playerService.get(id1);
        Player player2 = playerService.get(id2);

        if(player1 == null || player2 == null){
            throw new ResourceNotFoundException("Player not found");
        }
        opponentService.add(player1, player2);
    }

    @DeleteMapping(value = "/{id1}/{id2}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){

        Player player1 = playerService.get(id1);
        Player player2 = playerService.get(id2);

        if(player1 == null || player2 == null){
            throw new ResourceNotFoundException("Player not found");
        }
        opponentService.add(player1, player2);
    }
}
