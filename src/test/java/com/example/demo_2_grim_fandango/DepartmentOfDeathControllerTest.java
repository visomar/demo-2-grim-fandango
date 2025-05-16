package com.example.demo_2_grim_fandango;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DepartmentOfDeathControllerTest {

	DepartmentOfDeathController toTest = new DepartmentOfDeathController();

	@Test
	void testExceptionIsThrown() {
		TravelAgent mannyCalavera = new TravelAgent("Manny Calavera");
		Customer merche = new Customer("Merche Colomar", Customer.TypeOfPersonInLife.GOOD_PERSON);
		Pair pair = new Pair(mannyCalavera, merche);

		ResponseStatusException responseStatusException = assertThrows(ResponseStatusException.class, () -> {
			toTest.organizeTravelPackage(pair);
		});

		assertThat(responseStatusException.getStatus()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}
}