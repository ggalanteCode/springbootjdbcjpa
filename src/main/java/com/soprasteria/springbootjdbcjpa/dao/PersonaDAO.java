package com.soprasteria.springbootjdbcjpa.dao;

import java.time.LocalDate;
import java.util.List;

import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO2;
import com.soprasteria.springbootjdbcjpa.entity.Persona;

public interface PersonaDAO {

	public List<PersonaMacchinaDTO2> criteriaLeftJoin(LocalDate date);

	public List<PersonaMacchinaDTO> sqlLeftJoin(LocalDate date);
	
	public Persona savePersona(Persona persona);
	
	public List<Persona> findListaPersone();
	
	public List<PersonaMacchinaDTO> findNativeQuery(LocalDate date);

}
