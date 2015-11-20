package com.networkmi.facade;

import java.util.List;

import com.networkmi.model.Usuario;

public interface UsuarioService {

	/**
	 * Metodo que retorna todos os usuarios cadastros no banco de dados
	 * @return
	 */
	List<Usuario> obterTodosUsuario();
	
	/**
	 * Recupera todas as informacoes do usuario pela pk
	 * @param id
	 * @return
	 */
	Usuario obterUsuarioPorId(Integer id);
	
	/**
	 * Metodo que insere um usuario do app na base
	 * @param usuario
	 */
	Usuario inserirUsuario(Usuario usuario);
	
	
	/**
	 * Metodo que retorna os dados do usuario caso 
	 * @param usuario
	 * @return
	 */
	Usuario obterUsuarioLogadoPorEmail(Usuario usuario);
	
	/**
	 * Metodo que insere categorias em um usuario por id de usuario
	 * @param usuario
	 * @return
	 */
	Usuario insereCategoriaUsuario(Usuario usuario);
	
}
