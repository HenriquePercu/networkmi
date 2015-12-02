package com.networkmi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.networkmi.dao.EventoDao;
import com.networkmi.model.Evento;
import com.networkmi.util.HibernateUtil;

@Repository
public class EventoDaoImpl implements EventoDao{

	@Override
	public Evento inserirEvento(Evento evento) {
		try{
			Session session = HibernateUtil.openSession();
			
			session.beginTransaction();
			session.save(evento);	
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return evento;	
	}

	@Override
	public List<Evento> obterTodosEventos() {
		Criteria criteria = HibernateUtil.openSession().createCriteria(Evento.class);
		
		return criteria.list();
	}

	
	public Evento updateEvento(Evento evento){
		try{
			Session session = HibernateUtil.openSession();
			
			session.beginTransaction();
			session.update(evento);	
			session.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return evento;	
		
	}

	@Override
	public Evento obterEventoPorId(Integer id) {
		Criteria criteria = HibernateUtil.openSession().createCriteria(Evento.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Evento) criteria.uniqueResult();
	}
}
