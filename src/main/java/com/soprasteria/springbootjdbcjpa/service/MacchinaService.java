package com.soprasteria.springbootjdbcjpa.service;

import java.util.List;

import com.soprasteria.springbootjdbcjpa.entity.Macchina;

public interface MacchinaService {
	
	public List<Macchina> getListaMacchine();
	
	public Macchina createMacchina(Macchina macchina);

}
