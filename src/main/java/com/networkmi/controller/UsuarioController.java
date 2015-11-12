package com.networkmi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.networkmi.facade.UsuarioService;
import com.networkmi.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formulario";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adiciona(@Valid Usuario usuario, BindingResult result) {
		if (result.hasFieldErrors()) {
			return "usuario/formulario";
		}
		System.out.println(usuario);
		usuarioService.inserirUsuario(usuario);
		return "usuario/adicionado";
	}

	@RequestMapping("listaUsuarios")
	public String lista(Model model) {
		model.addAttribute("usuarios", usuarioService.obterTodosUsuario());
		return "usuario/lista";
	}
}
