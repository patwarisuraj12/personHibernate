package com.person.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Person {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Id
	private Integer Id;
	
	private String firstName;
	private String lastName;
	private Integer age;
	private String dob;

}
