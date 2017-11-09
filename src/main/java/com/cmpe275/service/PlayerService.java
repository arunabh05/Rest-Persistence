package com.cmpe275.service;

import com.cmpe275.domain.Player;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */
public interface PlayerService{

    Player create(Player player);
    Player get(Long playerId);
    Player update(Player player);
    Player delete(Long playerId);
}
