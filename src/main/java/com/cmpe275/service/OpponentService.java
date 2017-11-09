package com.cmpe275.service;

import com.cmpe275.domain.Player;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 */
public interface OpponentService {

    String add(Player player1, Player player2);
    String remove(Player player1, Player player2);
}
