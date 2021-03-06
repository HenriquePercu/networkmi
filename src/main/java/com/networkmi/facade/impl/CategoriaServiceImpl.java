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
	@Transactional 
	public CategoriaVO obterCategoriaPorId(Short id) {
		// TODO Auto-generated method stub
		return getCategoriaVO(categoriaDao.obterCategoriaPorId(id));
	}

	@Override
	@Transactional 
	public List<HashtagVO> obterHashtagsPorNome(Short idCategoria, String nome) {
		return getHashtagVO(categoriaDao.obtemHashtagsPorNome(idCategoria, nome));
	}
	

	@Override
	public List<CategoriaVO> obterListaCategoriaPorId(List<Short> listaCategorias) {
		return getListaHashTagVO(categoriaDao.obtemListaCategorias(listaCategorias));
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

	private List<HashtagVO> getHashtagVO(List<Hashtag> hashtags){
		
		ArrayList<HashtagVO> hashtagVO = new ArrayList<HashtagVO>();
		
		for (Hashtag hashtag : hashtags) {
			hashtagVO.add(new HashtagVO(hashtag));
		}
		
		return hashtagVO;
		
	}
	
	private List<CategoriaVO> getListaHashTagVO(List<Categoria> listaCategoriasDao){
		
		ArrayList<CategoriaVO> listaCategoriaVO = new ArrayList<CategoriaVO>();
		
		for (Categoria categoriaDao : listaCategoriasDao) {
			
			listaCategoriaVO.add(getCategoriaVO(categoriaDao));
			
		}
				
		return listaCategoriaVO;
			
	}

}
