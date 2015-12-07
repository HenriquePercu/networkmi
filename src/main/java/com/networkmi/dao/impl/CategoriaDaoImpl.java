package com.networkmi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.networkmi.dao.CategoriaDao;
import com.networkmi.model.Categoria;
import com.networkmi.model.Hashtag;
import com.networkmi.model.Usuario;
import com.networkmi.util.HibernateUtil;

@Repository
public class CategoriaDaoImpl implements CategoriaDao{

	@Override
	public Categoria inserirCategoria(Categoria categoria) {
		try{
			Session session = HibernateUtil.openSession();
			
			session.beginTransaction();
			session.save(categoria);	
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return categoria;	
	}

	@Override
	public List<Categoria> obterTodasCategorias() {
		Criteria criteria = HibernateUtil.openSession().createCriteria(Categoria.class);
		
		return criteria.list();
	}

	
	public Categoria updateCategoria(Categoria categoria){
		try{
			Session session = HibernateUtil.openSession();
			
			session.beginTransaction();
			session.update(categoria);	
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return categoria;	
		
	}

	@Override
	public Categoria obterCategoriaPorId(Short id) {
		Criteria criteria = HibernateUtil.openSession().createCriteria(Categoria.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Categoria) criteria.uniqueResult();
	}

	@Override
	public List<Hashtag> obtemHashtagsPorNome(Short idCategoria, String nome) {
	
		Criteria criteria = HibernateUtil.openSession().createCriteria(Hashtag.class);
		criteria.add(Restrictions.eq("categoria.id", idCategoria));
		criteria.add(Restrictions.ilike("descricao", nome, MatchMode.ANYWHERE));
		
		return criteria.list();
	}
}
