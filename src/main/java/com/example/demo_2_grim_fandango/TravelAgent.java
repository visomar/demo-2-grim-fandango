package com.example.demo_2_grim_fandango;

public record TravelAgent(String name) {

	String sellPackage(Customer customer) {
		return customer.name() + ", enjoy your trip through the Land of the Dead";
	}
}
