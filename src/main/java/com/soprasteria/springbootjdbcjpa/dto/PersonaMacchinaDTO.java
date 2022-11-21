package com.soprasteria.springbootjdbcjpa.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaMacchinaDTO {
	
	private String personaNome;
	private String personaCognome;
	private String macchinaMarca;
	private String macchinaModello;
	private String macchinaTarga;
	private Date dataImmatricolazione;
	private Integer cc;
	
}
