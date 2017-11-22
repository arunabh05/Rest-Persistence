package com.cmpe275.service;

import com.cmpe275.domain.Player;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Player service.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
public interface PlayerService{

    /**
     * Create player.
     *
     * @param player the player
     * @return the player
     */
    @Transactional
    Player create(Player player);

    /**
     * Get player.
     *
     * @param playerId the player id
     * @return the player
     */
    Player get(Long playerId);

    /**
     * Update player.
     *
     * @param player the player
     * @return the player
     */
    @Transactional
    Player update(Player player);

    /**
     * Delete player.
     *
     * @param playerId the player id
     * @return the player
     */
    @Transactional
    Player delete(Long playerId);
}
