package com.example.demo_2_grim_fandango;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DepartmentOfDeathController {

	@PostMapping("/")
	public String organizeTravelPackage(@RequestBody Pair pair) {
		TravelAgent agent = pair.agent();
		Customer customer = pair.customer();

		if (customer.typeOfPersonInLife() == Customer.TypeOfPersonInLife.GOOD_PERSON) {
			// Let's make them walk, and save the ticket for Hector LeMans
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE); // 406 Not Acceptable
		}
		return agent.sellPackage(customer);
	}

}
