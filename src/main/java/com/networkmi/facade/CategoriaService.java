package com.networkmi.facade;

import java.util.List;

import com.networkmi.model.Categoria;

public interface CategoriaService {

	/**
	 * Insere categoria no banco de dados
	 * @param categoria
	 * @return
	 */
	Categoria inserirCategoria(Categoria categoria);
	
	/**
	 * Obter todas as categorias
	 * @return
	 */
	List<Categoria> obterTodasCategorias();
	
}
