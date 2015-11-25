package com.networkmi.model.to;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.networkmi.model.Hashtag;

@JsonInclude(Include.NON_NULL)
public class UsuarioVO extends TransferObject{

	private Integer id;
	
	private String nome;
	
	private Date dataNascimento;

	private String email;

	private Boolean isUsuarioAtivo;

	private Date dataCadastro;
	
	private String password;
	
	private String urlFoto;
	
//	private Set<Evento> eventos = new HashSet<Evento>(0);

	private Collection<CategoriaVO> categorias;
	
	private ArrayList<Hashtag> hashtags;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsUsuarioAtivo() {
		return isUsuarioAtivo;
	}

	public void setIsUsuarioAtivo(Boolean isUsuarioAtivo) {
		this.isUsuarioAtivo = isUsuarioAtivo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public ArrayList<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(ArrayList<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}

	public Collection<CategoriaVO> getCategorias() {
		return categorias;
	}

	public void setCategorias(Collection<CategoriaVO> categorias) {
		this.categorias = categorias;
	}
	
	
	
}
