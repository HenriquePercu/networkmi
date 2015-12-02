package com.networkmi.dao;

import java.util.List;

import com.networkmi.model.Evento;

public interface EventoDao {

	Evento inserirEvento(Evento evento);
	
	List<Evento> obterTodosEventos();

	Evento updateEvento(Evento evento);
	
	Evento obterEventoPorId(Integer id);
}
