package com.networkmi.facade;

import java.util.List;

import com.networkmi.model.Usuario;
import com.networkmi.model.to.UsuarioVO;

public interface UsuarioService {

	/**
	 * Metodo que retorna todos os usuarios cadastros no banco de dados
	 * @return
	 */
	List<UsuarioVO> obterTodosUsuario();
	
	/**
	 * Recupera todas as informacoes do usuario pela pk
	 * @param id
	 * @return
	 */
	UsuarioVO obterUsuarioPorId(Integer id);
	
	/**
	 * Metodo que insere um usuario do app na base
	 * @param usuario
	 */
	UsuarioVO inserirUsuario(Usuario usuario);
	
	
	/**
	 * Metodo que retorna os dados do usuario caso 
	 * @param usuario
	 * @return
	 */
	UsuarioVO obterUsuarioLogadoPorEmail(Usuario usuario);

	/**
	 * Metodo que insere as hashtags no usuario
	 * @param usuario
	 * @return
	 */
	UsuarioVO insereHashtagUsuario(Usuario usuario);
	
	
	/**
	 * Metodo que atrela um evento ao usuario
	 * @param usuario
	 * @return
	 */
	UsuarioVO insereEvento(Usuario usuario);
	
}
