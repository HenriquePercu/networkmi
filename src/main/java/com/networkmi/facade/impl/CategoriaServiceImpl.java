package com.networkmi.facade.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.networkmi.dao.CategoriaDao;
import com.networkmi.facade.CategoriaService;
import com.networkmi.model.Categoria;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService{

	private CategoriaDao categoriaDao;
	
	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
	@Transactional
	public Categoria inserirCategoria(Categoria categoria) {
		return categoriaDao.inserirCategoria(categoria);
	}

	@Override
	@Transactional
	public List<Categoria> obterTodasCategorias() {
		return categoriaDao.obterTodasCategorias();
	}

}
