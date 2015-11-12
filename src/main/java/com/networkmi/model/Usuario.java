package com.networkmi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.networkmi.model.Evento;
import com.networkmi.util.DateUtil;

@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="NM_USUARIO")
	@NotNull
	@Size(min = 5)
	private String nome;
	
	@Column(name="DT_NASCIMENTO")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name="FLG_ATIVO")
	private Boolean isUsuarioAtivo;
	
	@Column(name="DT_CADASTRO")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataCadastro;
	
	@Column(name="DSC_HASHTAGS")
	private String hashtags;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_EVENTO" , joinColumns = { 
			@JoinColumn(name = "ID_USUARIO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_EVENTO", 
					nullable = false) })
	private Set<Evento> categories = new HashSet<Evento>(0);
	
	public Usuario(){}
	
	public Usuario(String nome){
		this.nome = nome;
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

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public Set<Evento> getCategories() {
		return categories;
	}

	public void setCategories(Set<Evento> categories) {
		this.categories = categories;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString(){
		return new StringBuffer("[").append(this.id).append("]")
			.append("[").append(this.nome).append("]")
			.append("[").append(DateUtil.format(this.dataNascimento)).append("]")
			.append("[").append(this.email).append("]")
			.append("[").append(this.isUsuarioAtivo).append("]")
			.append("[").append(DateUtil.format(this.dataCadastro)).append("]")
			.append("[").append(this.hashtags).append("]").toString();
	}
	
}
