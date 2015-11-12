package com.networkmi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.networkmi.dao.UsuarioDao;
import com.networkmi.model.Usuario;
import com.networkmi.util.HibernateUtil;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Override
	public List<Usuario> getTodosUsuarios() {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Usuario.class);
		
		return criteria.list();
	}

	@Override
	public void inserirUsuario(Usuario usuario) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			session.beginTransaction();
			session.save(usuario);	
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(e);
		}
				
	}

	@Override
	public Usuario obterUsuarioPorId(Integer id) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Usuario) criteria.uniqueResult();
	}

	@Override
	public Usuario obterUsuarioPorEmail(String email) {
		Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		
		return (Usuario) criteria.uniqueResult();
	}

	
}
