package com.cmpe275.service;

import com.cmpe275.domain.Sponsor;
import com.cmpe275.exceptions.ResourceNotFoundException;
import com.cmpe275.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arunabh.shrivastava on 11/8/2017.
 *
 */
@Service
public class SponsorServiceImpl implements SponsorService{

    private final SponsorRepository sponsorRepository;

    @Autowired
    public SponsorServiceImpl(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public Sponsor get(Long sponsorId){
        return sponsorRepository.findOne(sponsorId);
    }

    @Override
    public Sponsor delete(Long sponsorId) {

        Sponsor sponsor = sponsorRepository.findOne(sponsorId);
        if(sponsor == null){
            throw new ResourceNotFoundException("Sponsor not found");
        }
        sponsorRepository.delete(sponsorId);
        return sponsor;
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Sponsor create(Sponsor sponsor){
        return sponsorRepository.save(sponsor);
    }
}
