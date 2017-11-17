package com.cmpe275.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 */

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "SPONSOR")
public class Sponsor {

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

    @Id
    @GeneratedValue
    private long id;
    @NotNull
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

    public Sponsor(Long id, String name, String description, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
    }
}
