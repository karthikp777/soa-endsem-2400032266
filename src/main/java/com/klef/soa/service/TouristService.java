
package com.klef.soa.service;

import org.springframework.stereotype.Service;

import com.klef.soa.entity.Tourist;
import com.klef.soa.repository.TouristRepository;
import com.klef.soa.exception.TouristNotFoundException;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    // ADD TOURIST
    public Tourist addTourist(Tourist tourist) {

        return repository.save(tourist);
    }

    // DISPLAY TOURIST BY ID
    public Tourist getTouristById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new TouristNotFoundException(
                        "Tourist not found with ID: " + id));
    }

    
}
