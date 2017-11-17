package com.cmpe275.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 */

@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID")
    private long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @Column(unique = true)
    private String email;
    private String description;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Sponsor sponsor;
    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<Opponents> opponents;

    public Player(){}

    @Autowired
    public Player(String firstname, String lastname, String email, String description, Address address, Sponsor sponsor){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.description = description;
        this.address = address;
        this.sponsor = sponsor;
    }

    @Autowired
    public Player(Long playerId, String firstname, String lastname, String email, String description, Address address, Sponsor sponsor){
        this.id = playerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.description = description;
        this.address = address;
        this.sponsor = sponsor;
    }

    public void addOpponent(Opponents opponent){
        opponents.add(opponent);
    }

    public void removeOpponent(Opponents opponent){
        opponents.remove(opponent);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public List<Opponents> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponents> opponents) {
        this.opponents = opponents;
    }
}
