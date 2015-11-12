package com.networkmi.model;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USUARIO_EVENTO")
@AssociationOverrides({
		@AssociationOverride(name = "pk.usuario", 
			joinColumns = @JoinColumn(name = "ID_USUARIO")),
		@AssociationOverride(name = "pk.evento", 
			joinColumns = @JoinColumn(name = "ID_EVENTO")) })
public class UsuarioEvento {

	@EmbeddedId
	private UsuarioEventoId pk = new UsuarioEventoId();
	
	@Column( name = "FLG_PRESENTE" )
	private Boolean isCompareceuEvento;
	
	@Column( name = "DT_INSCRICAO" )
	private Date dataInscricaoEvento;
		
	@Transient
	public Usuario getUsuario(){
		return getPk().getUsuario();
	}
	
	public void setUsuario(Usuario usuario){
		getPk().setUsuario(usuario);
	}
	
	@Transient
	public Evento getEvento(){
		return getPk().getEvento();
	}
	
	public void setEvento(Evento evento){
		getPk().setEvento(evento);
	}
	
	public UsuarioEventoId getPk() {
		return pk;
	}
	public void setPk(UsuarioEventoId pk) {
		this.pk = pk;
	}
	public Boolean getIsCompareceuEvento() {
		return isCompareceuEvento;
	}
	public void setIsCompareceuEvento(Boolean isCompareceuEvento) {
		this.isCompareceuEvento = isCompareceuEvento;
	}
	public Date getDataInscricaoEvento() {
		return dataInscricaoEvento;
	}
	public void setDataInscricaoEvento(Date dataInscricaoEvento) {
		this.dataInscricaoEvento = dataInscricaoEvento;
	}
	
}
