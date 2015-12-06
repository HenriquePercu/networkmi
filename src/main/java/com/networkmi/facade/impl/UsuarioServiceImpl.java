package com.networkmi.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.networkmi.constants.FaultMessages;
import com.networkmi.dao.UsuarioDao;
import com.networkmi.dao.impl.UsuarioDaoImpl;
import com.networkmi.facade.UsuarioService;
import com.networkmi.model.Hashtag;
import com.networkmi.model.Usuario;
import com.networkmi.model.to.CategoriaVO;
import com.networkmi.model.to.HashtagVO;
import com.networkmi.model.to.UsuarioVO;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	private static final Logger log = Logger.getLogger(UsuarioDaoImpl.class.getName());

	/*Classes de acesso ao banco*/
	private UsuarioDao usuarioDao;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	@Transactional
	public List<UsuarioVO> obterTodosUsuario() {
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		
		for (Usuario usuario : usuarioDao.getTodosUsuarios()) {
			listaUsuarios.add(getUsuarioVO(usuario));
		}
		
		return listaUsuarios;
	}

	@Override
	@Transactional
	public UsuarioVO inserirUsuario(Usuario usuario) {
		
		usuario.setIsUsuarioAtivo(Boolean.TRUE);
		usuario.setDataCadastro(new Date());
		
		try{
			
			usuario =  this.usuarioDao.inserirUsuario(usuario);		
			
			if(usuario.getId() == null)
				throw new ConstraintViolationException("Usuario ja existente", null, "EMAIL");
			
		}catch(ConstraintViolationException constraintViolationException){
			
			usuario = new Usuario();
			usuario.setFaultInfo(FaultMessages.USUARIO_EXISTENTE);
			
		}catch(Exception e){
			
			usuario = new Usuario();
			usuario.setFaultInfo(FaultMessages.ERRO_GENERICO);		
			
		}
		
		return getUsuarioVO(usuario);
	}

	@Override
	@Transactional
	public UsuarioVO obterUsuarioPorId(Integer id) {
		Usuario usuario = usuarioDao.obterUsuarioPorId(id);
		
		return getUsuarioVO(usuario);
	}

	@Override
	@Transactional
	public UsuarioVO obterUsuarioLogadoPorEmail(Usuario usuarioLogado) {
		Usuario usuarioBase = usuarioDao.obterUsuarioPorEmail(usuarioLogado.getEmail());
		
		if(usuarioBase == null){
			usuarioBase = new Usuario();
			usuarioBase.setFaultInfo(FaultMessages.USUARIO_NAO_CADASTRADO);
		}else if(!usuarioBase.getPassword().equals(usuarioLogado.getPassword())){
			usuarioBase = new Usuario();
			usuarioBase.setFaultInfo(FaultMessages.SENHA_INCORRETA);
		}
		
		log.info("Usuario inserido com sucesso");
		
		return getUsuarioVO(usuarioBase);
	}

	@Override
	@Transactional
	public UsuarioVO insereHashtagUsuario(Usuario usuario) {
		Usuario usuarioCadastrado = usuarioDao.obterUsuarioPorId(usuario.getId());
		
		/*Lista categorias que serao alteradas*/
		List<Short> categoriasSelecionadas = getListaCategoriasSelecionadas(usuario.getHashtags());

		/*Retiras todas as hashtags com as categorias acima  da usuarioCadastrado*/
		removeCategoriasUsuario(usuarioCadastrado, categoriasSelecionadas);
		
		/*Adiciona hashtags para update*/
		usuarioCadastrado.getHashtags().addAll(usuario.getHashtags());

		return getUsuarioVO(usuarioDao.updateUsuario(usuarioCadastrado));
	}
	
	private UsuarioVO getUsuarioVO(Usuario usuario){
		UsuarioVO usuarioVO = new UsuarioVO();
		
		usuarioVO.setNome(usuario.getNome());
		usuarioVO.setId(usuario.getId());
		usuarioVO.setNome(usuario.getNome());
		usuarioVO.setDataCadastro(usuario.getDataCadastro());
		usuarioVO.setEmail(usuario.getEmail());
		usuarioVO.setUrlFoto(usuario.getUrlFoto());
		usuarioVO.setDataNascimento(usuario.getDataNascimento());
		
		HashMap<Short , CategoriaVO> categorias = new HashMap< Short , CategoriaVO>();	
		
		for (Hashtag hashtag : usuario.getHashtags()) {
			
			if(!categorias.containsKey(hashtag.getCategoria().getId())){
				CategoriaVO categoria = new CategoriaVO();
				
				categoria.setId(hashtag.getCategoria().getId());
				categoria.setDescricaoCategoria(hashtag.getCategoria().getDescricaoCategoria());
				categoria.setHashtags(new ArrayList<HashtagVO>());
				
				categorias.put(categoria.getId(), categoria);
			}
			
			categorias.get(hashtag.getCategoria().getId()).getHashtags().add(new HashtagVO(hashtag));
			
		}
		
		usuarioVO.setCategorias(categorias.values());
	
		return usuarioVO;
	}
	
	private List<Short> getListaCategoriasSelecionadas(Set<Hashtag> hashtags ) {
		List<Short> listaCategorias = new ArrayList<Short>();
		
		for (Hashtag hashtag : hashtags) {

			listaCategorias.add(hashtag.getCategoria().getId());
			
		}
		
		return listaCategorias;
	}
	
	private void removeCategoriasUsuario(Usuario usuario , List<Short> categorias){
		
		for(Iterator<Hashtag> i = usuario.getHashtags().iterator(); i.hasNext();) {
			Hashtag hashtag = i.next();
			
			if(categorias.contains(hashtag.getCategoria().getId())){
				i.remove();
			}
			
		}
		
	}

}
