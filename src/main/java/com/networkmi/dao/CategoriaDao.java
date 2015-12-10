package com.networkmi.dao;

import java.util.List;

import com.networkmi.model.Categoria;
import com.networkmi.model.Hashtag;

public interface CategoriaDao {

	Categoria inserirCategoria(Categoria categoria);
	
	List<Categoria> obterTodasCategorias();

	Categoria updateCategoria(Categoria categoria);
	
	Categoria obterCategoriaPorId(Short id);
	
	List<Hashtag> obtemHashtagsPorNome(Short idCategoria , String nome);
	
	List<Categoria> obtemListaCategorias(List<Short> listaCategorias);
	
}
