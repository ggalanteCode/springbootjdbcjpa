package com.soprasteria.springbootjdbcjpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soprasteria.springbootjdbcjpa.dao.PersonaDAO;
import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.entity.Persona;
import com.soprasteria.springbootjdbcjpa.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public Persona createPersona(Persona persona) {
		// TODO Auto-generated method stub
		return personaDAO.savePersona(persona);
	}

	@Override
	public List<Persona> getListaPersone() {
		// TODO Auto-generated method stub
		return personaDAO.findListaPersone();
	}

	@Override
	public List<PersonaMacchinaDTO> sqlLeftJoin(LocalDate date) {
		// TODO Auto-generated method stub
		return personaDAO.findNativeQuery(date);
	}

	@Override
	public List<PersonaMacchinaDTO> criteriaLeftJoin(LocalDate date) {
		// TODO Auto-generated method stub
		return personaDAO.criteriaLeftJoin(date);
	}

}
