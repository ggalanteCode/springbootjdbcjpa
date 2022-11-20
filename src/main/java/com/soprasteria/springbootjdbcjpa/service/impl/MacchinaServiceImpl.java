package com.soprasteria.springbootjdbcjpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soprasteria.springbootjdbcjpa.dao.MacchinaDAO;
import com.soprasteria.springbootjdbcjpa.entity.Macchina;
import com.soprasteria.springbootjdbcjpa.service.MacchinaService;

@Service
public class MacchinaServiceImpl implements MacchinaService {
	
	@Autowired
	private MacchinaDAO macchinaDAO;
	
	//PER LA FIND ALL
	@Override
	public List<Macchina> getListaMacchine() {
		// TODO Auto-generated method stub
		List<Macchina> macchine = macchinaDAO.findListaMacchine();
		return macchine;
	}

	@Override
	public Macchina createMacchina(Macchina macchina) {
		// TODO Auto-generated method stub
		return macchinaDAO.saveMacchina(macchina);
	}

}
