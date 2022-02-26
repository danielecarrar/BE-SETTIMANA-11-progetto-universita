package it.epicode.segreteria.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Studente {

	private int id;
	@NotNull
	private String nome;
	@NotNull
	private String cognome;
	@NotNull
	private String email;
	@NotNull
	private String data;
	@NotNull
	private String indirizzo;
	@NotNull
	private String citta;
	
	private Corso corso;

	@Override
	public String toString() {
		return "Info Studente con id: " + id + ", nome: " + nome + ", cognome: " + cognome + ", email: " + email
				+ ", data di nascita: " + data + ", indirizzo: " + indirizzo + ", citta: " + citta + ", "
				+ corso;
	}
}