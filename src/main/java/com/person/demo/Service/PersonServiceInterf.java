package com.person.demo.Service;

import java.util.List;

import com.person.demo.Model.Person;
import com.person.demo.ModelDto.PersonDto;

public interface PersonServiceInterf {
	
	Person getPerson(int id);
	void createPerson(PersonDto personDto);
	void deletePerson(int id);
	List<Person> getAllPerson();
	
}
