package com.soprasteria.springbootjdbcjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.soprasteria.springbootjdbcjpa.dao.MacchinaDAO;
import com.soprasteria.springbootjdbcjpa.entity.Macchina;

@Repository
@Transactional
public class MacchinaDAOImpl implements MacchinaDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	//USO DI CRITERIA BUILDER PER LA FIND ALL
	@Override
	public List<Macchina> findListaMacchine() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Macchina> cq = cb.createQuery(Macchina.class);
        Root<Macchina> rootEntry = cq.from(Macchina.class);
        CriteriaQuery<Macchina> all = cq.select(rootEntry);
        TypedQuery<Macchina> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

	@Override
	public Macchina saveMacchina(Macchina macchina) {
		// TODO Auto-generated method stub
		return entityManager.merge(macchina);
	}

}
