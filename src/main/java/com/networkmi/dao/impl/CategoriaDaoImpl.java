package com.networkmi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.networkmi.dao.CategoriaDao;
import com.networkmi.model.Categoria;
import com.networkmi.model.Usuario;
import com.networkmi.util.HibernateUtil;

@Repository
public class CategoriaDaoImpl implements CategoriaDao{

	@Override
	public Categoria inserirCategoria(Categoria categoria) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			
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
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Categoria.class);
		
		return criteria.list();
	}

}
