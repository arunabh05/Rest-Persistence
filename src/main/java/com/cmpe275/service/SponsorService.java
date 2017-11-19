package com.cmpe275.service;

import com.cmpe275.domain.Sponsor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */
public interface SponsorService {

    @Transactional
    Sponsor create(Sponsor sponsor);
    Sponsor get(Long sponsorId);
    @Transactional
    Sponsor delete(Long sponsorId);
    @Transactional
    Sponsor update(Sponsor sponsor);
}
