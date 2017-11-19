package com.cmpe275.controller;

import com.cmpe275.domain.Player;
import com.cmpe275.service.OpponentService;
import com.cmpe275.service.PlayerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 * Opponent Controller to add or remove {@link Player} opponents.
 */


@RestController
@Api(value = "Opponent management endpoint", description = "This API performs add and remove operations on Players to manage opponents.")
@RequestMapping(value = "/opponents")
public class OpponentController {

    private final PlayerService playerService;
    private final OpponentService opponentService;

    /**
     * Instantiates a new PlayerController
     *
     * @param playerService        {@link PlayerService} to perform actions on sponsor object
     * @param opponentService      {@link OpponentService} to manage player's opponent list
     */
    @Autowired
    public OpponentController(PlayerService playerService, OpponentService opponentService) {
        this.playerService = playerService;
        this.opponentService = opponentService;
    }

    /**
     * Creates opponent relation between both the {@link Player}
     *
     * @param id1        Player Id of first player.
     * @param id2        Player Id of second player.
     *
     * @return Success Message on success, or HttpStatus.NOT_FOUND if player doesn't exists.
     */
    @PutMapping(value = "/{id1}/{id2}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> add(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){

        Player player1 = playerService.get(id1);
        Player player2 = playerService.get(id2);

        if(player1 == null || player2 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(opponentService.add(player1, player2), HttpStatus.OK);
    }

    /**
     * Removes opponent relation between both the {@link Player}
     *
     * @param id1        Player Id of first player.
     * @param id2        Player Id of second player.
     *
     * @return Success Message on success, or HttpStatus.NOT_FOUND if player doesn't exists.
     */
    @DeleteMapping(value = "/{id1}/{id2}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> remove(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){

        Player player1 = playerService.get(id1);
        Player player2 = playerService.get(id2);

        if(player1 == null || player2 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(opponentService.remove(player1, player2), HttpStatus.OK);
    }
}
