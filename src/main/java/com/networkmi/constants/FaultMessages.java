package com.networkmi.constants;

import com.networkmi.model.to.FaultInfo;

public class FaultMessages {

	public static FaultInfo USUARIO_NAO_CADASTRADO = new FaultInfo(Short.valueOf("1"), "Usu�rio n�o cadastrado");
	public static FaultInfo SENHA_INCORRETA = new FaultInfo(Short.valueOf("2"), "Senha Incorreta");
	public static FaultInfo USUARIO_EXISTENTE = new FaultInfo(Short.valueOf("3"), "Usu�rio j� cadastrado");
	public static FaultInfo ERRO_GENERICO = new FaultInfo(Short.valueOf("4"), "Sistema Indispon�vel no Momento");
}