package com.test.petclinic.service;

import com.test.petclinic.model.PetType;
import com.test.petclinic.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public PetType save(PetType petType) {
        petTypeRepository.findByPetTypeIgnoreCase(petType.getPetType())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Pet type already exists: " + petType.getPetType());
                });
        return petTypeRepository.save(petType);
    }

    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }
}
