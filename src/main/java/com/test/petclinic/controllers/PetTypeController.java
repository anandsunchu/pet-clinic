package com.test.petclinic.controllers;

import com.test.petclinic.dtos.PetTypeDTO;
import com.test.petclinic.model.PetType;
import com.test.petclinic.service.PetTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet-type")
public class PetTypeController {

    @Autowired
    private PetTypeService petTypeService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public PetTypeDTO create(@RequestBody PetTypeDTO petTypeDTO) {
        return mapper.map(petTypeService.save(mapper.map(petTypeDTO, PetType.class)), PetTypeDTO.class);
    }

    @GetMapping
    public List<PetTypeDTO> getAll() {
        return petTypeService.findAll().stream().map(petType -> mapper.map(petType, PetTypeDTO.class)).toList();
    }
}
