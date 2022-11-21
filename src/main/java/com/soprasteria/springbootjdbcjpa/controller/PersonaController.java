package com.soprasteria.springbootjdbcjpa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.entity.DataImmatricolazione;
import com.soprasteria.springbootjdbcjpa.entity.Persona;

public interface PersonaController {

	public ResponseEntity<Object> getAllPersone();

	public ResponseEntity<Object> getPersonaById(Integer pId);

	public ResponseEntity<Object> createNewPersona(Persona persona);

	public ResponseEntity<Object> updatePersona(Persona persona);

	public ResponseEntity<Object> deletePersona(Integer pId);
	
	public ResponseEntity<List<PersonaMacchinaDTO>> leftJoinWithSQL(DataImmatricolazione dataImmatricolazione);
	
	public ResponseEntity<Object> leftJoinWithCriteria(DataImmatricolazione dataImmatricolazione);

}
