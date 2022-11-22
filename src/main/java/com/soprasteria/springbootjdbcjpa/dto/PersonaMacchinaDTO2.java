package com.soprasteria.springbootjdbcjpa.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaMacchinaDTO2 {
	
	private String personaNome;
	private String personaCognome;
	private String macchinaMarca;
	private String macchinaModello;
	private String macchinaTarga;
	private LocalDate annoImmatricolazione;
	private Integer cc;

}
