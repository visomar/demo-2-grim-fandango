package com.example.demo_2_grim_fandango;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo2GrimFandangoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testOrganizingTravelForBadPeople() {
		TravelAgent mannyCalavera = new TravelAgent("Manny Calavera");
		Customer celso = new Customer("Celso Flores", Customer.TypeOfPersonInLife.BAD_PERSON);
		Pair pair = new Pair(mannyCalavera, celso);

		String response = restTemplate.postForObject("/", pair, String.class);

		assertThat(response).isEqualTo("Celso Flores, enjoy your trip to the Land of the Dead");
	}

	@Test
	void testOrganizingTravelForGoodPeople() {
		TravelAgent mannyCalavera = new TravelAgent("Manny Calavera");
		Customer merche = new Customer("Merche Colomar", Customer.TypeOfPersonInLife.GOOD_PERSON);
		Pair pair = new Pair(mannyCalavera, merche);

		ResponseEntity<String> response = restTemplate.postForEntity("/", pair, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
	}

}
