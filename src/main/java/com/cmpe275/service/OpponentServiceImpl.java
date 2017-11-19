package com.cmpe275.service;

import com.cmpe275.domain.Player;
import com.cmpe275.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arunabh.shrivastava on 11/16/2017.
 *
 */

@Service
public class OpponentServiceImpl implements OpponentService {

    private final PlayerRepository playerRepository;

    @Autowired
    public OpponentServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public String add(Player player1, Player player2) {

        player1.addOpponent(player2);
        player2.addOpponent(player1);

        playerRepository.save(player1);
        playerRepository.save(player2);

        return new String(player1.getEmail() + " and " + player2.getEmail() + "are now opponents.");
    }

    @Override
    public String remove(Player player1, Player player2) {

        player1.removeOpponent(player2);
        player2.removeOpponent(player1);

        playerRepository.save(player1);
        playerRepository.save(player2);

        return new String(player1.getEmail() + " and " + player2.getEmail() + "are no longer opponents.");
    }
}
