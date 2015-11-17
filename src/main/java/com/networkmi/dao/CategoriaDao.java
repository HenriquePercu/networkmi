package com.networkmi.dao;

import java.util.List;

import com.networkmi.model.Categoria;

public interface CategoriaDao {

	Categoria inserirCategoria(Categoria categoria);
	
	List<Categoria> obterTodasCategorias();
	
}
