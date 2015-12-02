package com.networkmi.facade;

import java.util.List;

import com.networkmi.model.Categoria;
import com.networkmi.model.Evento;
import com.networkmi.model.to.CategoriaVO;
import com.networkmi.model.to.EventoVO;

public interface EventoService {

	/**
	 * Insere evento no banco de dados
	 * @param evento
	 * @return
	 */
	Evento inserirEvento(Evento evento);
	
	/**
	 * Obter todos os eventos
	 * @return
	 */
	List<EventoVO> obterTodosEventos();
	
	
	/**
	 * Obtem evento por id
	 * @param id
	 * @return
	 */
	EventoVO obterEventoPorId(Integer id);
}
