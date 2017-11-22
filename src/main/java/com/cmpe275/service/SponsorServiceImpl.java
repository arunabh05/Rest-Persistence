package com.cmpe275.service;

import com.cmpe275.domain.Sponsor;
import com.cmpe275.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Sponsor service.
 *
 * @author arunabh.shrivastava
 * @author sagar.mane
 */
@Service
public class SponsorServiceImpl implements SponsorService{

    private final SponsorRepository sponsorRepository;

    /**
     * Instantiates a new Sponsor service.
     *
     * @param sponsorRepository the sponsor repository
     */
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
