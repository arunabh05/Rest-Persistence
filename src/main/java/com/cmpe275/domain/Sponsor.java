package com.cmpe275.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 * Sponsor class to manage sponsor details and address.
 */
@Entity
@Table(name = "SPONSOR")
public class Sponsor {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    private String description;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "sponsor")
    private List<Player> playerList;

    /**
     * Instantiates a new Sponsor
     *
     */
    public Sponsor(){}

    /**
     * Instantiates a new Sponsor
     *
     * @param name          Name of the sponsor
     * @param description   Description of the sponsor
     * @param address       Address of the sponsor
     */
    public Sponsor(String name, String description, Address address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    /**
     * Instantiates a new Sponsor
     *
     * @param id            Id of the sponsor
     * @param name          Name of the sponsor
     * @param description   Description of the sponsor
     * @param address       Address of the sponsor
     */
    public Sponsor(Long id, String name, String description, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
    }

    /**
     * Gets the sponsor id.
     *
     * @return          id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the sponsor id
     *
     * @param id         Sponsor id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the sponsor name.
     *
     * @return id           Sponsor id
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the sponsor name
     *
     * @param name         Name of the sponsor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the sponsor
     *
     * @return description         Description of the sponsor
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the sponsor
     *
     * @param description         Name of the sponsor
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the address of the sponsor
     *
     * @return address         Address of the sponsor
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the sponsor
     *
     * @param address         Address of the sponsor
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the list of players sponsored by the sponsor
     *
     * @return playerList         An ArrayList of Players
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Sets the list of players sponsored by the sponsor
     *
     * @param  playerList         An ArrayList of Players
     */
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
