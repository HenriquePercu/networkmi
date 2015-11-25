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
import com.networkmi.model.Categoria;
import com.networkmi.model.to.CategoriaVO;

@RestController
@RequestMapping("/service/categorias/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Autowired
	private CategoriaService categoriaService;
    
	@GET
	@RequestMapping("/todos")
	public List<CategoriaVO> getTodasCategorias(){
		List<CategoriaVO> retorno = categoriaService.obterTodasCategorias(); 
		return retorno;
	}
	
	@RequestMapping(value = "/obtercategoria/{id}" , method = RequestMethod.GET)
	public CategoriaVO obterCategoriaPorId(@PathVariable Integer id ){
		return categoriaService.obterCategoriaPorId(id.shortValue());		
	}
	
	@RequestMapping(value = "/inserirhashtag" , method = RequestMethod.POST)
	public CategoriaVO inserirHashtag(@RequestBody Categoria categoria ){
		return categoriaService.inserirHashTagsCategoria(categoria);
	}
	
	
}
