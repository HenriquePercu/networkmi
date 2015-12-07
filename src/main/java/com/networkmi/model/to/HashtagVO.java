package com.networkmi.model.to;

import com.networkmi.model.Hashtag;

public class HashtagVO {

	public HashtagVO(){}
	
	public HashtagVO(Hashtag hashtag){
		this.setDescricao(hashtag.getDescricao());
		this.setId(hashtag.getId());
		this.setIdCategoria(hashtag.getCategoria().getId());
	}

	private Short id;
	private String descricao;
	private Short idCategoria;
	
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Short idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
