package com.networkmi.model.to;

import com.networkmi.model.Hashtag;

public class HashtagVO {

	public HashtagVO(){}
	
	public HashtagVO(Hashtag hashtag){
		this.setDescricao(hashtag.getDescricao());
		this.setId(hashtag.getId());
	}

	private Short id;
	private String descricao;
	
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
	
}
