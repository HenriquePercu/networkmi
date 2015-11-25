package com.networkmi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.networkmi.facade.UsuarioService;
import com.networkmi.model.Usuario;
import com.networkmi.model.to.UsuarioVO;


@RestController
@RequestMapping("/service/usuarios/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
    @Autowired
	private UsuarioService usuarioService;
	
	@GET
	@RequestMapping("/todos")
	public List<UsuarioVO> getTodosUsuarios(){
		List<UsuarioVO> retorno = usuarioService.obterTodosUsuario(); 
		return retorno;
	}
	
	@RequestMapping(value = "/obterusuario/{id}" , method = RequestMethod.GET)
	public UsuarioVO obterUsuario(@PathVariable Integer id ){
		return usuarioService.obterUsuarioPorId(id);		
	}
	
	@RequestMapping(value =  "/inserirusuario" , method = RequestMethod.POST)
	public UsuarioVO inserirUsuario( @RequestBody Usuario usuario){
		
		return usuarioService.inserirUsuario(usuario);
			
	}
	
	@RequestMapping( value =  "/inserirmuitosusuairo" , method = RequestMethod.POST)
	public void inserirMuitosUsuarios( @RequestBody List<Usuario> usuario){
		
		System.out.println("");
			
	}

	@RequestMapping( value =  "/login" , method = RequestMethod.POST)
	public UsuarioVO login(@RequestBody Usuario usuario){
		
		return usuarioService.obterUsuarioLogadoPorEmail(usuario);
		
	}
	
	@RequestMapping( value =  "/inserirhashtag" , method = RequestMethod.POST)
	public UsuarioVO insereHashtag(@RequestBody Usuario usuario){
		
		return usuarioService.insereHashtagUsuario(usuario);
		
	}
	
	
}


	

