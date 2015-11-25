package com.networkmi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name="CATEGORIA")
public class Categoria {

	@Id
	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	@GeneratedValue
	private Short id;
	
	@Column( name = "DSC_CATEGORIA")
	private String descricaoCategoria;

	@Column(name = "URL_FOTO")
	private String urlFoto;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "categoria" , cascade = CascadeType.ALL)
	private Set<Hashtag> hashtags = new HashSet<Hashtag>(0); 

	public Categoria() {}
	
	public Categoria(Short id , String descricaoCategoria , Set<Hashtag> hashtags){
		this.setId(id);
		this.setDescricaoCategoria(descricaoCategoria);
		this.setHashtags(hashtags);
	}
	
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
/*
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
*/
	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Set<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}
	
	
	
}
