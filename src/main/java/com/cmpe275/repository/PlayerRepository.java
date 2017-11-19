package com.cmpe275.repository;

import com.cmpe275.domain.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 * PlayerRepository to perform CRUD opertions on {@link Player} in database.
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
