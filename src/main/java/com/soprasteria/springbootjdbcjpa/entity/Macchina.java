package com.soprasteria.springbootjdbcjpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Macchina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modello;
	
	@Column(nullable = false)
	private String targa;
	
	@Column(name = "anno_immatricolazione", nullable = false)
	private LocalDate annoImmatricolazione;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "id_persona")
	@JsonBackReference
	private Persona persona;

}
