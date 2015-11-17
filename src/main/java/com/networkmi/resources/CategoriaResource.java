package com.networkmi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.networkmi.facade.CategoriaService;
import com.networkmi.model.Categoria;
import com.networkmi.model.Usuario;

@RestController
@RequestMapping("/service/categorias/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Autowired
	private CategoriaService categoriaService;
    
	@GET
	@RequestMapping("/todos")
	public List<Categoria> getTodasCategorias(){
		List<Categoria> retorno = categoriaService.obterTodasCategorias(); 
		return retorno;
	}
	
}
