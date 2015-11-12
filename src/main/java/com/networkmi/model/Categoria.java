package com.networkmi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {

	@Id
	@GeneratedValue
	private Short id;
	
	@Column( name = "DSC_CATEGORIA")
	private String descricaoCategoria;
	
}
