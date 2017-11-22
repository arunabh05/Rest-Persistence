package com.cmpe275.service;

import com.cmpe275.domain.Player;
import com.cmpe275.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Player service.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    /**
     * Instantiates a new Player Service.
     *
     * @param playerRepository the player repository
     */
    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player create(Player player){

        if(playerRepository.findPlayerByEmail(player.getEmail()) == null){
               return playerRepository.save(player);
        }
        return null;
    }

    @Override
    public Player get(Long playerId){ return playerRepository.findOne(playerId); }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player delete(Long playerId) {
        Player player = playerRepository.findOne(playerId);
        playerRepository.delete(playerId);
        return player;
    }
}
