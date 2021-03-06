package com.networkmi.facade;

import java.util.List;

import com.networkmi.model.Categoria;
import com.networkmi.model.to.CategoriaVO;
import com.networkmi.model.to.HashtagVO;

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
	List<CategoriaVO> obterTodasCategorias();
	
	
	/**
	 * Update categoria incluindo as hashtags
	 * @param categoria
	 * @return
	 */
	CategoriaVO inserirHashTagsCategoria(Categoria categoria);
	
	/**
	 * Obtem categoria por id
	 * @param id
	 * @return
	 */
	CategoriaVO obterCategoriaPorId(Short id);
	
	/**
	 * Obtem hashtags por like atrav�s de uma categoria
	 * @param idCategoria
	 * @param nome
	 * @return
	 */
	List<HashtagVO> obterHashtagsPorNome(Short idCategoria , String nome);
	
	/**
	 * Retorna uma lista de categorias e suas hashtags de acordo com uma lista de ID passados por parametro
	 * @param listaCategorias
	 * @return
	 */
	List<CategoriaVO> obterListaCategoriaPorId(List<Short> listaCategorias);
	
}
