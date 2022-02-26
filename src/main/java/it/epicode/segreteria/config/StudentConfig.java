package it.epicode.segreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import it.epicode.segreteria.model.Corso;
import it.epicode.segreteria.model.Segreteria;
import it.epicode.segreteria.model.Studente;

@Configuration
public class StudentConfig {

	@Bean
	public Segreteria segreteria() {
		Segreteria segreteria = new Segreteria();
		Corso c1 = new Corso("Biologia", 5);
		Studente sc1 = new Studente(0, "Marco", "Larese", "email@email.it", "1990-12-09", "Via Da Li 12", "Viterbo", c1);
		
		Corso c2 = new Corso("Storia", 6);
		Studente sc2 = new Studente(1, "Luca", "Ragno", "email2@email.it", "1991-11-02", "Via Salvador 122/a", "Napoli", c2);
		
		segreteria.getListaStudenti().add(sc1);
		segreteria.getListaStudenti().add(sc2);
		
		Corso c3 = new Corso("Scienze Politiche", 4);
		Corso c4 = new Corso("Inglese", 7);
		Corso c5 = new Corso("Francese", 6);
		Corso c6 = new Corso("Astrofisica", 8);
		
		segreteria.getListaCorsi().add(c1);
		segreteria.getListaCorsi().add(c2);
		segreteria.getListaCorsi().add(c3);
		segreteria.getListaCorsi().add(c4);
		segreteria.getListaCorsi().add(c5);
		segreteria.getListaCorsi().add(c6);
		
		return segreteria;
	}
	
	@Bean
	public Studente studente() {
		return new Studente();
	}	
	@Bean
	public Corso corso() {
		return new Corso();
	}	
}