package com.cmpe275.domain;

import javax.persistence.*;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 */

@Entity
@Table(name = "SPONSOR")
public class Sponsor {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @Embedded
    private Address address;

    public Sponsor(){}

    public Sponsor(String name, String description, Address address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
