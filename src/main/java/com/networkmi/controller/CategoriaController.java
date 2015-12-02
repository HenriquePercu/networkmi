package com.networkmi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.networkmi.facade.CategoriaService;
import com.networkmi.model.Categoria;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("novaCategoria")
	public String form() {
		return "categoria/formulario";
	}
	
	@RequestMapping("adicionaCategoria")
	public String adiciona(@Valid Categoria categoria, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "categoria/formulario";
		}

		categoriaService.inserirCategoria(categoria);
		return "categoria/adicionado";
	}

	@RequestMapping("insereHashtag")
	public String insereHashtag(@Valid Categoria categoria, BindingResult result) {
		
		categoriaService.inserirHashTagsCategoria(categoria);
		
		return "/service/categorias/todos";
		
	}
	
}
