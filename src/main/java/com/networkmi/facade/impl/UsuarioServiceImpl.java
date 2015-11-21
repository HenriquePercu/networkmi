package com.networkmi.facade.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.networkmi.constants.FaultMessages;
import com.networkmi.dao.UsuarioDao;
import com.networkmi.facade.UsuarioService;
import com.networkmi.model.Usuario;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	/*Classes de acesso ao banco*/
	private UsuarioDao usuarioDao;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	@Transactional
	public List<Usuario> obterTodosUsuario() {
		return usuarioDao.getTodosUsuarios();
	}

	@Override
	@Transactional
	public Usuario inserirUsuario(Usuario usuario) {
		
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
		
		return usuario;
	}

	@Override
	@Transactional
	public Usuario obterUsuarioPorId(Integer id) {
		Usuario usuario = usuarioDao.obterUsuarioPorId(id);
		
		return usuario;
	}

	@Override
	@Transactional
	public Usuario obterUsuarioLogadoPorEmail(Usuario usuarioLogado) {
		Usuario usuarioBase = usuarioDao.obterUsuarioPorEmail(usuarioLogado.getEmail());
		
		if(usuarioBase == null){
			usuarioBase = new Usuario();
			usuarioBase.setFaultInfo(FaultMessages.USUARIO_NAO_CADASTRADO);
		}else if(!usuarioBase.getPassword().equals(usuarioLogado.getPassword())){
			usuarioBase = new Usuario();
			usuarioBase.setFaultInfo(FaultMessages.SENHA_INCORRETA);
		}
		
		return usuarioBase;
	}

	@Override
	@Transactional
	public Usuario insereCategoriaUsuario(Usuario usuario) {
		Usuario usuarioCadastrado = usuarioDao.obterUsuarioPorId(usuario.getId());
		
		usuarioCadastrado.setCategorias(usuario.getCategorias());
		
		return usuarioDao.updateUsuario(usuarioCadastrado);
	}
	
	

}
