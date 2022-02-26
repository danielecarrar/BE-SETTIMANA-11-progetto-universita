package it.epicode.segreteria.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Corso {

//	private final String FISICA = "Fisica";
//	private final String STORIA = "Storia";
//	private final String ALIMENTAZIONE = "Alimentazione";
//	private final String ITALIANO = "Italiano";
//	private final String BIOLOGIA = "Biologia";
//	private final String MATEMATICA = "Matematica";
//	private final String SCIENZE = "Scienze";
	@NotNull
	private String Corso;
	private int Esami;
	@Override
	public String toString() {
		return "Materia Corso: " + Corso + ", Esami totali: " + Esami;
	}
	

}