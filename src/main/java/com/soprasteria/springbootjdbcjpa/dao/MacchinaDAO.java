package com.soprasteria.springbootjdbcjpa.dao;

import java.util.List;

import com.soprasteria.springbootjdbcjpa.entity.Macchina;

public interface MacchinaDAO {
	
	public List<Macchina> findListaMacchine();
	
	public Macchina saveMacchina(Macchina macchina);

}
