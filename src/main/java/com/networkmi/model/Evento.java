package com.networkmi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EVENTO")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVENTO", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "LATITUDE")
	private Double latitude;
	
	@Column(name = "LONGITUDE")
	private Double longitude;
	
	@Column(name = "DT_EVENTO")
	private Date dataEvento;
	
	@Column(name = "DSC_EVENTO")
	private String descricaoEvento;
	
	@Column(name = "DSC_ASSUNTO")
	private String descricaoAssuntoEvento;
	
		
}
