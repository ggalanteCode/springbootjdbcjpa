package com.soprasteria.springbootjdbcjpa.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springbootjdbcjpa.controller.MacchinaController;
import com.soprasteria.springbootjdbcjpa.entity.Macchina;
import com.soprasteria.springbootjdbcjpa.service.MacchinaService;

@RestController
@RequestMapping("/macchine")
public class MacchinaControllerImpl implements MacchinaController {
	
	@Autowired
	private MacchinaService macchinaService;
	
	@Override
	@GetMapping("/allMacchine")
	public ResponseEntity<Object> getAllMacchine() {
		return new ResponseEntity<Object>(macchinaService.getListaMacchine(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/macchinaByid/{mId}")
	public ResponseEntity<Object> getMacchinaById(@PathVariable(value = "mId") Integer mId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/createMacchina")
	public ResponseEntity<Object> createNewMacchina(@RequestBody Macchina macchina) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(macchinaService.createMacchina(macchina),HttpStatus.OK);
	}

	@Override
	@PutMapping("/updateMacchina")
	public ResponseEntity<Object> updateMacchina(Macchina macchina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/deleteMacchina/{mId}")
	public ResponseEntity<Object> deleteMacchina(@PathVariable(value = "mId") Integer mId) {
		// TODO Auto-generated method stub
		return null;
	}

}
