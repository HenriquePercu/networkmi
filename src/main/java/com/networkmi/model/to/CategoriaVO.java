package com.networkmi.model.to;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.networkmi.model.Hashtag;

@JsonInclude(Include.NON_NULL)
public class CategoriaVO extends TransferObject{

	private Short id;
	private String descricaoCategoria;
	private String urlFoto;
	private ArrayList<HashtagVO> hashtags;

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

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public ArrayList<HashtagVO> getHashtags() {
		return hashtags;
	}

	public void setHashtags(ArrayList<HashtagVO> hashtags) {
		this.hashtags = hashtags;
	} 
	
	
	
}
