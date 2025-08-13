package com.test.petclinic;

import com.test.petclinic.model.PetType;
import com.test.petclinic.repositories.PetTypeRepository;
import com.test.petclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PetClinicApplicationTests {
	@Mock
	private PetTypeRepository petTypeRepository;

	@InjectMocks
	private PetTypeService petTypeService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void savePetType_ShouldReturnSavedPetType() {
		PetType pet = new PetType();
		pet.setPetType("Dog");
		pet.setTemperament("Playful");
		pet.setLength(40.0);
		pet.setWeight(15.0);

		when(petTypeRepository.save(any(PetType.class))).thenReturn(pet);

		PetType saved = petTypeService.save(pet);

		assertThat(saved).isNotNull();
		assertThat(saved.getPetType()).isEqualTo("Dog");
	}

	@Test
	void getAllPetTypes_ShouldReturnList() {
		when(petTypeRepository.findAll()).thenReturn(
				Arrays.asList(new PetType(), new PetType())
		);

		List<PetType> list = petTypeService.findAll();

		assertThat(list).hasSize(2);
	}

}
