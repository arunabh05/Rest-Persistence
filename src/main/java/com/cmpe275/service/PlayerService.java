package com.cmpe275.service;

import com.cmpe275.domain.Player;
import com.cmpe275.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 */
@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player create(Player player){
        return playerRepository.save(player);
    }
}
