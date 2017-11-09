package com.cmpe275.service;

import com.cmpe275.domain.Sponsor;

/**
 * Created by arunabh.shrivastava on 11/9/2017.
 *
 */
public interface SponsorService {

    Sponsor create(Sponsor sponsor);
    Sponsor get(Long sponsorId);
    Sponsor delete(Long sponsorId);
    Sponsor update(Sponsor sponsor);
}
