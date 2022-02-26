package it.epicode.segreteria.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Segreteria {
	private final List<Studente> listaStudenti = new ArrayList<>();
	private final List<Corso> listaCorsi = new ArrayList<>();
}