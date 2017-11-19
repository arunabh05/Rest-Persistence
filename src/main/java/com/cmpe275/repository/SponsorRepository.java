package com.cmpe275.repository;

import com.cmpe275.domain.Sponsor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 * SponsorRepository to perform CRUD opertions on {@link Sponsor} in database.
 */
public interface SponsorRepository extends CrudRepository<Sponsor, Long> {
}
