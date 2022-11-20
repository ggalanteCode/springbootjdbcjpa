package com.soprasteria.springbootjdbcjpa.controller;

import org.springframework.http.ResponseEntity;

import com.soprasteria.springbootjdbcjpa.entity.Macchina;

public interface MacchinaController {
	
	public ResponseEntity<Object> getAllMacchine();
	
	public ResponseEntity<Object> getMacchinaById(Integer mId);
	
	public ResponseEntity<Object> createNewMacchina(Macchina macchina);
	
	public ResponseEntity<Object> updateMacchina(Macchina macchina);
	
	public ResponseEntity<Object> deleteMacchina(Integer mId);

}
