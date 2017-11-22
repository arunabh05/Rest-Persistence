package com.cmpe275.service;

import com.cmpe275.domain.Sponsor;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Sponsor Service.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
public interface SponsorService {

    /**
     * Create sponsor.
     *
     * @param sponsor the sponsor
     * @return the sponsor
     */
    @Transactional
    Sponsor create(Sponsor sponsor);

    /**
     * Get sponsor.
     *
     * @param sponsorId the sponsor id
     * @return the sponsor
     */
    Sponsor get(Long sponsorId);

    /**
     * Delete sponsor.
     *
     * @param sponsorId the sponsor id
     * @return the sponsor
     */
    @Transactional
    Sponsor delete(Long sponsorId);

    /**
     * Update sponsor.
     *
     * @param sponsor the sponsor
     * @return the sponsor
     */
    @Transactional
    Sponsor update(Sponsor sponsor);
}
