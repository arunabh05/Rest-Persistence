package com.cmpe275.service;

import com.cmpe275.domain.Opponents;
import com.cmpe275.domain.Player;
import com.cmpe275.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arunabh.shrivastava on 11/16/2017.
 */

@Service
public class OpponentServiceImpl implements OpponentService {


    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void add(Player player1, Player player2) {

        Opponents opponent1 = new Opponents(player1);
        Opponents opponent2 = new Opponents(player2);

        player1.addOpponent(opponent2);
        player2.addOpponent(opponent1);

        playerRepository.save(player1);
        playerRepository.save(player2);
    }

    @Override
    public void remove(Player player1, Player player2) {

        Opponents opponent1 = new Opponents(player1);
        Opponents opponent2 = new Opponents(player2);

        player1.removeOpponent(opponent2);
        player2.removeOpponent(opponent1);

        playerRepository.save(player1);
        playerRepository.save(player2);
    }
}
