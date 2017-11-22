package com.cmpe275.repository;

import com.cmpe275.domain.Sponsor;
import org.springframework.data.repository.CrudRepository;

/**
 * SponsorRepository to perform CRUD opertions on {@link Sponsor} in database.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
public interface SponsorRepository extends CrudRepository<Sponsor, Long> {
}
