package it.epicode.segreteria.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import it.epicode.segreteria.config.StudentConfig;
import it.epicode.segreteria.model.Corso;
import it.epicode.segreteria.model.Segreteria;
import it.epicode.segreteria.model.Studente;

@Controller
public class UniController {

	private final Segreteria segreteria;
	private final ApplicationContext ctx;

	public UniController() {
		ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
		segreteria = (Segreteria) ctx.getBean("segreteria");
	}

	// http://localhost:8080/getstudenti
	@GetMapping("/getstudenti")
	public String getAllStudenti(Model model) {
		List<Studente> listaStudenti = segreteria.getListaStudenti();
		model.addAttribute("studenti", listaStudenti);
		return "getstudenti";
	}

	// vedi tutti i corsi
	@GetMapping("/corsi")
	public String getAllCorsi(Model model) {
		List<Corso> listaCorsi = segreteria.getListaCorsi();
		model.addAttribute("corsi", listaCorsi);
		return "corsi";
	}

	@GetMapping("/alunno")
	public ModelAndView showForm() {
		return new ModelAndView("inserisci", "alunno", new Studente());
	}

	// inserisci nuovo studente
	@PostMapping("/addalunno")
	public String submit(@Valid @ModelAttribute("alunno") Studente alunno, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
//		Corso corso = new Corso();
//		corso.setCorso(c.getCorso());
//		corso.setEsami(c.getEsami());
//		alunno.setCorso(corso);

		segreteria.getListaStudenti().add(alunno);

		// questi servono dopo per inserito.html
		model.addAttribute("id", alunno.getId());
		model.addAttribute("nome", alunno.getNome());
		model.addAttribute("cognome", alunno.getCognome());
		model.addAttribute("email", alunno.getEmail());
		model.addAttribute("data", alunno.getData());
		model.addAttribute("indirizzo", alunno.getIndirizzo());
		model.addAttribute("citta", alunno.getCitta());

		return "inserito";
	}

	@GetMapping("/elimina")
	public ModelAndView elimina() {
		return new ModelAndView("elimina", "studente", new Studente());
	}

	@GetMapping("/eliminaalunno")
	public String elimina(@ModelAttribute("studente") Studente studente, ModelMap model, BindingResult res) {

		List<Studente> listaStudents = segreteria.getListaStudenti();
		for (Studente s : listaStudents) {
			if (s.getId() == studente.getId()) {
				listaStudents.remove(s);
				System.out.println("eliminazione completata di " + s.toString());
			}
		}
		return "getstudenti";
	}

	// aggiornamento
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("studente") Studente studente, Corso corso, ModelMap model,
			BindingResult result, Model m) {

		List<Studente> listaStudenti = segreteria.getListaStudenti();

//		RESTITUISCE SEMPRE NULL! maledetto!
//		for (Studente s : listaStudenti) {
//			if (s.getId() == studente.getId()) {
//
//				model.addAttribute("id", s.getId());
//				model.addAttribute("nome", studente.getNome());
//				model.addAttribute("cognome", studente.getCognome());
//				model.addAttribute("data", studente.getData());
//				model.addAttribute("indirizzo", studente.getIndirizzo());
//				model.addAttribute("citta", studente.getCitta());
//				model.addAttribute("email", studente.getEmail());
//
//				listaStudenti.remove(s);
//
//				s.setId(s.getId());
//				s.setNome(studente.getNome());
//				s.setCognome(studente.getCognome());
//				s.setData(studente.getData());
//				s.setIndirizzo(studente.getIndirizzo());
//				s.setCitta(studente.getCitta());
//				s.setEmail(studente.getEmail());
//				listaStudenti.add(studente);
//
//				model.addAttribute("studenti", listaStudenti);
//
//			}
//		}
		return "getstudenti";
	}
}