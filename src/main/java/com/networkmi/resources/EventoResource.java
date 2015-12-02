package com.networkmi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.networkmi.facade.CategoriaService;
import com.networkmi.facade.EventoService;
import com.networkmi.model.Categoria;
import com.networkmi.model.to.CategoriaVO;
import com.networkmi.model.to.EventoVO;

@RestController
@RequestMapping("/service/eventos/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventoResource {

    @Autowired
	private EventoService eventoService;
    
	@GET
	@RequestMapping("/todos")
	public List<EventoVO> getTodosEventos(){
		List<EventoVO> retorno = eventoService.obterTodosEventos(); 
		return retorno;
	}
	
	@RequestMapping(value = "/obterevento/{id}" , method = RequestMethod.GET)
	public EventoVO obterEventoPorId(@PathVariable Integer id ){
		return eventoService.obterEventoPorId(id);		
	}
}
