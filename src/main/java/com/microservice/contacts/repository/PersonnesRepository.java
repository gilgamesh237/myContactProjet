package com.microservice.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.contacts.model.Personnes;

public interface PersonnesRepository extends JpaRepository<Personnes, Long> {

}
