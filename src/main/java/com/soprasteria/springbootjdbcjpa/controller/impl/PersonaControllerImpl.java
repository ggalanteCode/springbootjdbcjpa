package com.soprasteria.springbootjdbcjpa.controller.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springbootjdbcjpa.controller.PersonaController;
import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO2;
import com.soprasteria.springbootjdbcjpa.entity.DataImmatricolazione;
import com.soprasteria.springbootjdbcjpa.entity.Persona;
import com.soprasteria.springbootjdbcjpa.service.PersonaService;

@RestController
@RequestMapping("/persone")
public class PersonaControllerImpl implements PersonaController {
	
	@Autowired
	private PersonaService personaService;

	@Override
	@GetMapping("/allPersone")
	public ResponseEntity<Object> getAllPersone() {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(personaService.getListaPersone(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/personaById/{pId}")
	public ResponseEntity<Object> getPersonaById(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/newPersona")
	public ResponseEntity<Object> createNewPersona(@RequestBody Persona persona) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(personaService.createPersona(persona),HttpStatus.OK);
	}

	@Override
	@PutMapping("/updatePersona")
	public ResponseEntity<Object> updatePersona(@RequestBody Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/deletePersona/{pId}")
	public ResponseEntity<Object> deletePersona(Integer pId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * ENTRAMBE LE LEFT JOIN VENGONO FATTE TRAMITE IL CONTROLLER DI PERSONA
	 */

	@Override
	@GetMapping("/leftJoinSQL")
	public ResponseEntity<List<PersonaMacchinaDTO>> leftJoinWithSQL(@RequestBody DataImmatricolazione dataImmatricolazione) {
		// TODO Auto-generated method stub
		Integer anno = dataImmatricolazione.getAnno();
		Integer mese = dataImmatricolazione.getMese();
		Integer giorno = dataImmatricolazione.getGiorno();
		LocalDate date = LocalDate.of(anno, mese, giorno);
		List<PersonaMacchinaDTO> sqlLeftJoin = personaService.sqlLeftJoin(date);
		System.out.println("TEST");
		return new ResponseEntity<List<PersonaMacchinaDTO>>(sqlLeftJoin, HttpStatus.OK);
	}

	@Override
	@GetMapping("/leftJoinCriteria")
	public ResponseEntity<List<PersonaMacchinaDTO2>> leftJoinWithCriteria(@RequestBody DataImmatricolazione dataImmatricolazione) {
		// TODO Auto-generated method stub
		Integer anno = dataImmatricolazione.getAnno();
		Integer mese = dataImmatricolazione.getMese();
		Integer giorno = dataImmatricolazione.getGiorno();
		LocalDate date = LocalDate.of(anno, mese, giorno);
		return new ResponseEntity<List<PersonaMacchinaDTO2>>(personaService.criteriaLeftJoin(date), HttpStatus.OK);
	}

}
