package com.soprasteria.springbootjdbcjpa.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.soprasteria.springbootjdbcjpa.dao.PersonaDAO;
import com.soprasteria.springbootjdbcjpa.dto.PersonaMacchinaDTO;
import com.soprasteria.springbootjdbcjpa.entity.Macchina;
import com.soprasteria.springbootjdbcjpa.entity.Persona;

@Repository
@Transactional
public class PersonaDAOImpl implements PersonaDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	//CRITERIA LEFT JOIN
	@Override
	public List<PersonaMacchinaDTO> criteriaLeftJoin(LocalDate date) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PersonaMacchinaDTO> cq = cb.createQuery(PersonaMacchinaDTO.class);
		Root<Persona> pRoot = cq.from(Persona.class);
		Join<Persona, Macchina> macchinaJoin = pRoot.join("macchine", JoinType.LEFT);
		
		//DTO PROJECTION
		cq.select(cb.construct(PersonaMacchinaDTO.class,
				pRoot.get("nome"),
				pRoot.get("cognome"),
				macchinaJoin.get("marca"),
				macchinaJoin.get("modello"),
				macchinaJoin.get("targa")));
		Predicate onCond = cb.greaterThan(macchinaJoin.get("annoImmatricolazione"), date);
		macchinaJoin.on(onCond);
		
		//EXECUTE THE QUERY
		TypedQuery<PersonaMacchinaDTO> query = entityManager.createQuery(cq);
		List<PersonaMacchinaDTO> resList = query.getResultList();	//QUI VIENE FATTA LA SELECT CON LEFT JOIN
		return resList;
	}
	
	//SQL NATIVE QUERY LEFT JOIN
	@Override
	public List<Persona> sqlLeftJoin(LocalDate date) {
		Query query = entityManager.createNativeQuery("SELECT persona.nome, persona.cognome, macchina.marca, macchina.modello, macchina.targa "
				+ "FROM persona "
				+ "LEFT OUTER JOIN macchina ON "
				+ "persona.id = macchina.id_persona AND macchina.anno_immatricolazione > ?;");
		query.setParameter(1, date);
		List<Persona> resList = query.getResultList();
		return resList;
	}

	@Override
	public Persona savePersona(Persona persona) {
		// TODO Auto-generated method stub
		return entityManager.merge(persona);
	}

	@Override
	public List<Persona> findListaPersone() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> rootEntry = cq.from(Persona.class);
        CriteriaQuery<Persona> all = cq.select(rootEntry);
        TypedQuery<Persona> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

}
