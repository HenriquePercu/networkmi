package com.networkmi.dao;

import java.util.List;

import com.networkmi.model.Usuario;

public interface UsuarioDao {
	List<Usuario> getTodosUsuarios();
	
	Usuario obterUsuarioPorId(Integer id);
	
	Usuario obterUsuarioPorEmail(String email);
	
	Usuario inserirUsuario(Usuario usuario);
	
}
