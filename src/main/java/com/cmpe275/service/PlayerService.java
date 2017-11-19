package com.cmpe275.service;

import com.cmpe275.domain.Player;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */
public interface PlayerService{

    @Transactional
    Player create(Player player);
    Player get(Long playerId);
    @Transactional
    Player update(Player player);
    @Transactional
    Player delete(Long playerId);
}
