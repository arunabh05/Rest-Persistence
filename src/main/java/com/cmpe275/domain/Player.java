package com.cmpe275.domain;

import com.cmpe275.service.SponsorService;
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
    private long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private String email;
    private String description;

    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Sponsor sponsor;

    @ManyToOne
    private Player player;
    @OneToMany(mappedBy = "player")
    private List<Player> opponentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public List<Player> getOpponentList() {
        return opponentList;
    }

    public void setOpponentList(List<Player> opponentList) {
        this.opponentList = opponentList;
    }

    @Autowired
    public Player(String firstname, String lastname, String email, String description, Address address, Long sponsorId, Sponsor sponsor){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.description = description;
        this.address = address;
        this.sponsor = sponsor;
    }

    public Player(){}
}
