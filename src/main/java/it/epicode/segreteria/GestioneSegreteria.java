package it.epicode.segreteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.segreteria.config.StudentConfig;
import it.epicode.segreteria.model.Segreteria;

public class GestioneSegreteria {

	private final Segreteria segreteria;
	@Autowired
	private final ApplicationContext ctx;
	
	public GestioneSegreteria() {
		ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
		segreteria = (Segreteria) ctx.getBean("segreteria"); 
	}
	
	public void stampaInfo() {
		System.out.println("***Lista degli studenti attualmente iscritti***");
		segreteria.getListaStudenti().forEach(p -> System.out.println(p.toString() + "\n-------------------------------"));
		System.out.println("***Lista dei corsi disponibili***");
		segreteria.getListaCorsi().forEach(c -> System.out.println(c.toString()));
	}
}