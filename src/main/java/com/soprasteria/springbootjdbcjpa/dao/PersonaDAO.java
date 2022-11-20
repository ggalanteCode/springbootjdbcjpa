package com.soprasteria.springbootjdbcjpa.dao;

import java.time.LocalDate;
import java.util.List;

import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.entity.Persona;

public interface PersonaDAO {

	public List<PersonaMacchinaDTO> criteriaLeftJoin(LocalDate date);

	public List<Persona> sqlLeftJoin(LocalDate date);
	
	public Persona savePersona(Persona persona);
	
	public List<Persona> findListaPersone();

}
