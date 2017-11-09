package com.cmpe275.domain;

import javax.persistence.Embeddable;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 */
@Embeddable
public class Address {

    private String city;
    private String street;
    private String state;
    private Integer zip;

    public Address(){}

    public Address(String city, String street, String state, Integer zip) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() { return city; }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}
