package com.cmpe275.service;

import com.cmpe275.domain.Player;
import com.cmpe275.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 */
@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player create(Player player){
        return playerRepository.save(player);
    }

    @Override
    public Player get(Long playerId){ return playerRepository.findOne(playerId); }

    @Override
    public Player update(Player player) {
        return null;
    }

    @Override
    public Player delete(Long playerId) {
        return null;
    }

}
