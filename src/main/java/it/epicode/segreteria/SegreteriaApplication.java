package it.epicode.segreteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SegreteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegreteriaApplication.class, args);
		
		GestioneSegreteria segr = new GestioneSegreteria();
	segr.stampaInfo();
	}
}