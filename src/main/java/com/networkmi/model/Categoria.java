package com.networkmi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	/*Comentato por problema com o Serializer Json - Ficava em looping infinito*/
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
//	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

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
	
	
	
}
