package com.cmpe275.repository;

import com.cmpe275.domain.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * PlayerRepository to perform CRUD opertions on {@link Player} in database.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {

    public Player findPlayerByEmail(String email);
}
