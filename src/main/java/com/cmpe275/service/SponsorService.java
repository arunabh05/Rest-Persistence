package com.cmpe275.service;

import com.cmpe275.domain.Sponsor;
import com.cmpe275.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 */
@Service
public class SponsorService {

    @Autowired
    SponsorRepository sponsorRepository;

    public Sponsor get(Long sponsorId){
        return sponsorRepository.findOne(sponsorId);
    }

    public Sponsor create(Sponsor sponsor){
        return sponsorRepository.save(sponsor);
    }
}
