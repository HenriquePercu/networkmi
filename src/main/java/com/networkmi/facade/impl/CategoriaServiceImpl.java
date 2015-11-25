package com.networkmi.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.networkmi.dao.CategoriaDao;
import com.networkmi.facade.CategoriaService;
import com.networkmi.model.Categoria;
import com.networkmi.model.Hashtag;
import com.networkmi.model.to.CategoriaVO;
import com.networkmi.model.to.HashtagVO;

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
	public List<CategoriaVO> obterTodasCategorias() {
		
		ArrayList<CategoriaVO> listaCategoriasVO = new ArrayList<CategoriaVO>();
		
		for (Categoria categoria : categoriaDao.obterTodasCategorias()) {
			listaCategoriasVO.add(getCategoriaVO(categoria));
		}
		
		return listaCategoriasVO;
	}

	@Override
	@Transactional
	public CategoriaVO inserirHashTagsCategoria(Categoria categoria) {
		Categoria categoriaCadastrada = categoriaDao.obterCategoriaPorId(categoria.getId());
				
		for (Hashtag hashtag : categoria.getHashtags()) {
			hashtag.setCategoria(categoriaCadastrada);
		}
		
		categoriaCadastrada.setHashtags(categoria.getHashtags());
		
		categoriaDao.updateCategoria(categoriaCadastrada);
		
		CategoriaVO categoriaVO = getCategoriaVO(categoriaCadastrada);
		
		return categoriaVO;
	}

	@Override
	public CategoriaVO obterCategoriaPorId(Short id) {
		return getCategoriaVO(categoriaDao.obterCategoriaPorId(id));
	}

	
	private CategoriaVO getCategoriaVO(Categoria categoria){
		CategoriaVO categoriaVO = new CategoriaVO();
		
		categoriaVO.setDescricaoCategoria(categoria.getDescricaoCategoria());
		categoriaVO.setId(categoria.getId());
		categoriaVO.setUrlFoto(categoria.getUrlFoto());
		categoriaVO.setHashtags(new ArrayList<HashtagVO>());
		
		for (Hashtag hashtag : categoria.getHashtags()) {
			HashtagVO hashtagVO = new HashtagVO();
			hashtagVO.setDescricao(hashtag.getDescricao());
			hashtagVO.setId(hashtag.getId());
			categoriaVO.getHashtags().add(hashtagVO);
		}

		return categoriaVO;
	}
}
