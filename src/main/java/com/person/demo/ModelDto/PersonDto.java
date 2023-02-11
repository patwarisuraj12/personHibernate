package com.person.demo.ModelDto;

import com.person.demo.Model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PersonDto {
	
	private String firstName;
	private String lastName;
	private String dob;
	
	public Person to() {
		return Person.builder()
				.firstName(firstName)
				.lastName(lastName)
				.dob(dob).build();
	}

}
