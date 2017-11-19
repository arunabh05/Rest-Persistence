package com.cmpe275.domain;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 * Player class to manage player details, sponsors and opponents.
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
    @ManyToOne(cascade = CascadeType.DETACH)
    private Sponsor sponsor;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinTable( name = "opponents", joinColumns = @JoinColumn( name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "opponent_id"))
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private List<Player> opponents;

    /**
     * Instantiates a new Player
     *
     */
    public Player(){}

    /**
     * Instantiates a new Player
     * @param firstname         First name of the player
     * @param lastname          Last name of the player
     * @param email             Email address of the player
     * @param description       Description about the player
     * @param address           Address of the player
     * @param sponsor           Sponsor of the player
     *
     */
    @Autowired
    public Player(String firstname, String lastname, String email, String description, Address address, Sponsor sponsor){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.description = description;
        this.address = address;
        this.sponsor = sponsor;
    }

    /**
     * Instantiates a new Player
     * @param playerId          Unique id of the player.
     * @param firstname         First name of the player
     * @param lastname          Last name of the player
     * @param email             Email address of the player
     * @param description       Description about the player
     * @param address           Address of the player
     * @param sponsor           Sponsor of the player
     *
     */
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

    /**
     * Removes all opponents of the player.
     *
     */
    @PreRemove
    public void removeAllOpponents(){
        for(Iterator<Player> itr = this.opponents.iterator(); itr.hasNext();){
            Player opponent = itr.next();
            opponent.opponents.remove(this);
            itr.remove();
        }
    }

    /**
     * Adds a new opponent to the player's opponent list
     *
     * @param opponent         Opponent player
     */
    public void addOpponent(Player opponent){
        opponents.add(opponent);
    }

    /**
     * Removes an opponent from the player's opponent list
     *
     * @param opponent         Opponent player
     */
    public void removeOpponent(Player opponent){
        opponents.remove(opponent);
    }

    /**
     * Gets the Player id.
     *
     * @return          id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the player id
     *
     * @param id         Player id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the player
     *
     * @return firstname         First name of the player
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the player
     *
     * @param firstname         First name of the player
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the player
     *
     * @return lastname         Last name of the player
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the player
     *
     * @param lastname         Last name of the player
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the email address of the player
     *
     * @return firstname         First name of the player
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the player
     *
     * @param email         Email address of the player
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the description of the player.
     *
     * @return description         Description of the player
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the player
     *
     * @param description         Description of the player
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the address of the player.
     *
     * @return address         Address of the player
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the Address of the player
     *
     * @param address         Address of the player
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the Sponsor of the player.
     *
     * @return sponsor         Sponsor of the player
     */
    public Sponsor getSponsor() {
        return sponsor;
    }

    /**
     * Sets the Sponsor of the player
     *
     * @param sponsor         Sponsor of the player
     */
    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * Gets the list of opponents of the player
     *
     * @return opponents         An ArrayList of Players
     */
    public List<Player> getOpponents() {
        return opponents;
    }

    /**
     * Sets the list of opponents of the player
     *
     * @param opponents         An ArrayList of Players
     */
    public void setOpponents(List<Player> opponents) {
        this.opponents = opponents;
    }
}
