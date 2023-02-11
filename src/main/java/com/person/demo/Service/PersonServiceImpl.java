package com.person.demo.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.demo.Exception.PersonNotFoundException;
import com.person.demo.Model.Person;
import com.person.demo.ModelDto.PersonDto;
import com.person.demo.RepositoryInterf.PersonRepository;

@Service
public class PersonServiceImpl implements PersonServiceInterf {
	
	private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public Person getPerson(int id) {
		return personRepository.findById(id).orElseThrow(
				() -> new PersonNotFoundException("This person was not found in DB"));
			
	}

	@Override
	public void createPerson(PersonDto personDto) {
				
		Person person = personDto.to();
				
		if(person.getAge()==null) {
			person.setAge(calAgeFromDob(person.getDob()));
		}
		
		personRepository.save(person);

	}

	@Override
	public void deletePerson(int id) {
		personRepository.deleteById(id);
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	private Integer calAgeFromDob(String dob) {
		
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate sysDate = LocalDate.now();
	
		return Period.between(dobDate,sysDate).getYears();
		
	}

}
