package com.person.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.person.demo.Model.Person;
import com.person.demo.ModelDto.PersonDto;
import com.person.demo.Service.PersonServiceInterf;

@RestController
public class PersonController {
	
	@Autowired
	PersonServiceInterf personServiceInterf;
	
	@PostMapping("/person")
	public void createPerson(@RequestBody PersonDto personDto) {
		personServiceInterf.createPerson(personDto);
		
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		
		return personServiceInterf.getPerson(id);
	}
	
	@DeleteMapping("/person/delete/{id}")
	public ResponseEntity deletePerson(@PathVariable int id) {
		personServiceInterf.deletePerson(id);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPerson(){
		
		return personServiceInterf.getAllPerson();
	}

}
