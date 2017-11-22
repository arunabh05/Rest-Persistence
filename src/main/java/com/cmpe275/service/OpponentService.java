package com.cmpe275.service;

import com.cmpe275.domain.Player;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Opponent service.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
public interface OpponentService {

    /**
     * Adds opponent relation between Player1 and Player2.
     *
     * @param player1 the player 1
     * @param player2 the player 2
     * @return responseMessage
     */
    @Transactional
    String add(Player player1, Player player2);

    /**
     * Removes opponent relation between Player1 and Player2.
     *
     * @param player1 the player 1
     * @param player2 the player 2
     * @return responseMessage
     */
    @Transactional
    String remove(Player player1, Player player2);
}
