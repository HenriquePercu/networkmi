package com.networkmi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.networkmi.facade.EventoService;
import com.networkmi.model.Evento;

@Controller
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@RequestMapping("novoEvento")
	public String form() {
		return "evento/formulario";
	}
	
	@RequestMapping("adicionaEvento")
	public String adiciona(@Valid Evento evento, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "evento/formulario";
		}

		eventoService.inserirEvento(evento);
		return "evento/adicionado";
	}
}
