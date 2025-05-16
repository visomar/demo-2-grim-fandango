package com.example.demo_2_grim_fandango;

public record Customer(String name, TypeOfPersonInLife typeOfPersonInLife) {

	enum TypeOfPersonInLife {
		GOOD_PERSON,
		BAD_PERSON
	}
}
