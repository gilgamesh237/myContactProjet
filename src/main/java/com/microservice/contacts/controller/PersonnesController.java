package com.microservice.contacts.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.microservice.contacts.model.Personnes;
import com.microservice.contacts.repository.PersonnesRepository;

@Controller
public class PersonnesController {

	PersonnesRepository repository;
	public PersonnesController(PersonnesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/personnes")
	ResponseEntity<List<Personnes>> allPerson(){
		List<Personnes> poeple = new ArrayList<>();
		Iterable<Personnes> iterable = repository.findAll();
		iterable.forEach(p -> {
			poeple.add(p);
		});
	return new ResponseEntity<List<Personnes>>(poeple, HttpStatus.OK);
	}
	
	@GetMapping("/personnes/{id}")
	ResponseEntity<Personnes> onePerson(@PathVariable Long id){
		Optional<Personnes> request = repository.findById(id);
		if(!request.isPresent())
			return new ResponseEntity<Personnes>(new Personnes(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Personnes>(request.get(), HttpStatus.OK);	
	}
	
	@PostMapping("/personnes")
	ResponseEntity<Personnes> newPerson(@RequestBody Personnes p){
		Personnes person = repository.save(p);
		return new ResponseEntity<Personnes>(person, HttpStatus.OK);
	}
	
	@PutMapping("/personnes/{id}")
	ResponseEntity<Personnes> updatePerson(@PathVariable Long id, @RequestBody Personnes p){
		Optional<Personnes> request = repository.findById(id);
		if(!request.isPresent())
			return new ResponseEntity<Personnes>(new Personnes(), HttpStatus.BAD_REQUEST);
		Personnes c = request.get();
		c.setNom(p.getNom());
		c.setPrenom(p.getPrenom());
		c.setRoles(p.getRoles());
		repository.save(c);
		return new ResponseEntity<Personnes>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/personnes/{id}")
	ResponseEntity<Personnes> deletePerson(@PathVariable Long id){
		Optional<Personnes> request = repository.findById(id);
		if(!request.isPresent())
			return new ResponseEntity<Personnes>(new Personnes(), HttpStatus.BAD_REQUEST);
		repository.delete(request.get());
		return new ResponseEntity<Personnes>(new Personnes(), HttpStatus.OK);
	}

	
}

