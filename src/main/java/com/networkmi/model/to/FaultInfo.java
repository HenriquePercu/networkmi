package com.networkmi.model.to;

public class FaultInfo {
	
	private Short codigoErro;
	private String mensagemErro;
	
	public FaultInfo(){}
	
	public FaultInfo(Short codigoErro , String mensagemErro){
		this.codigoErro = codigoErro;
		this.mensagemErro = mensagemErro;
	}
	
	public Short getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(Short codigoErro) {
		this.codigoErro = codigoErro;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	
	
}
