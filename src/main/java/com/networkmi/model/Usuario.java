package com.networkmi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.networkmi.model.to.TransferObject;
import com.networkmi.util.DateUtil;

@Entity
@Table(name="USUARIO")
//@DynamicUpdate NAO FUNCIONANDO
//@SelectBeforeUpdate NAO FUNCIONANDO
public class Usuario extends TransferObject{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="NM_USUARIO")
	@Size(min = 5)
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(name = "EMAIL" , unique = true)
	private String email;

	@Column(name="FLG_ATIVO")
	private Boolean isUsuarioAtivo;
	
	@Column(name="DT_CADASTRO")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataCadastro;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "URL_FOTO")
	private String urlFoto;
	
	@ManyToMany(fetch = FetchType.LAZY /*, cascade = CascadeType.ALL*/)
	@JoinTable(name = "USUARIO_EVENTO" , joinColumns = { 
			@JoinColumn(name = "ID_USUARIO", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_EVENTO", 
					nullable = false) })
	private Set<Evento> eventos = new HashSet<Evento>(0);
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USUARIO_HASHTAG" , joinColumns = { 
			@JoinColumn(name = "ID_USUARIO", nullable = false , updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_HASHTAG", 
					nullable = false, updatable = false) })
	private Set<Hashtag> hashtags = new HashSet<Hashtag>(0);
	
	public Usuario(){}
	
	public Usuario(String nome){
		this.nome = nome;
	}
	
	public Usuario(Integer id){
		this.id = id;
	}
	
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

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
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

	@Override
	public String toString(){
		return new StringBuffer("[").append(this.id).append("]")
			.append("[").append(this.nome).append("]")
			.append("[").append(DateUtil.format(this.dataNascimento)).append("]")
			.append("[").append(this.email).append("]")
			.append("[").append(this.password).append("]")
			.append("[").append(this.urlFoto).append("]")
			.append("[").append(this.isUsuarioAtivo).append("]")
			.append("[").append(DateUtil.format(this.dataCadastro)).append("]")
			.append("[").append(this.hashtags).append("]").toString();
	}

	public Set<Hashtag> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Set<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}
	
}
