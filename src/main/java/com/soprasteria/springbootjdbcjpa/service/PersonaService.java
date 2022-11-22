package com.soprasteria.springbootjdbcjpa.service;

import java.time.LocalDate;
import java.util.List;

import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO2;
import com.soprasteria.springbootjdbcjpa.entity.Persona;

public interface PersonaService {
	
	public List<Persona> getListaPersone();
	
	public Persona createPersona(Persona persona);
	
	public List<PersonaMacchinaDTO> sqlLeftJoin(LocalDate date);
	
	public List<PersonaMacchinaDTO2> criteriaLeftJoin(LocalDate date);

}
