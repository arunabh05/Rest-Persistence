package com.cmpe275.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */


@RestController
@Api(value = "Opponent management endpoint", description = "This API performs add and remove operations on Players to manage opponents.")
@RequestMapping(value = "/api/v1/sponsor")
public class OpponentController {

    @PutMapping(value = "/{id1}/{id2}")
    public String add(){
        return null;
    }

    @DeleteMapping(value = "/{id1}/{id2}")
    public String remove(){
        return null;
    }
}
