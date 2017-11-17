package com.cmpe275.domain;

import com.cmpe275.service.OpponentService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arunabh.shrivastava on 11/16/2017.
 */

@Entity
@Table(name = "OPPONENTS")
public class Opponents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPPONENT_ID")
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYER_ID")
    Player player;
    public Opponents(){}


    public Opponents(Long id, Player player) {
        this.id = id;
        this.player = player;
    }

    public Opponents(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
