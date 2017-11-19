package com.cmpe275.service;

import com.cmpe275.domain.Player;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */
public interface OpponentService {

    @Transactional
    String add(Player player1, Player player2);
    @Transactional
    String remove(Player player1, Player player2);
}
