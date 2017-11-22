package com.cmpe275.domain;

import javax.persistence.Embeddable;

/**
 * Address class to store players and opponents address.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 *
 * @see Player
 * @see Sponsor
 */
@Embeddable
public class Address {

    private String city;
    private String street;
    private String state;
    private Integer zip;

    /**
     * Instantiates a new Address.
     */
    public Address(){}

    /**
     * Instantiates a new Address.
     *
     * @param city      city name
     * @param state     state name
     * @param street    street number and name
     * @param zip       zip code
     */
    public Address(String city, String street, String state, Integer zip) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Gets city name.
     *
     * @return city the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name
     *
     * @param city the city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets street number and name
     *
     * @return street the street number and name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street number and name
     *
     * @param street the street number and name
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets state name
     *
     * @return state the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state name
     *
     * @param state the state name
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip code address
     *
     * @return zip the zip code address
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Sets the zip code
     *
     * @param zip the zip code address
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }
}
