package com.networkmi.facade.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.networkmi.dao.CategoriaDao;
import com.networkmi.dao.EventoDao;
import com.networkmi.facade.CategoriaService;
import com.networkmi.facade.EventoService;
import com.networkmi.model.Categoria;
import com.networkmi.model.Evento;
import com.networkmi.model.Hashtag;
import com.networkmi.model.to.CategoriaVO;
import com.networkmi.model.to.EventoVO;
import com.networkmi.model.to.HashtagVO;

@Service("eventoService")
public class EventoServiceImpl implements EventoService {

	private EventoDao eventoDao;
	
	public void setEventoDao(EventoDao eventoDao) {
		this.eventoDao = eventoDao;
	}

	@Override
	@Transactional
	public Evento inserirEvento(Evento evento) {
		return eventoDao.inserirEvento(evento);
	}

	@Override
	@Transactional
	public List<EventoVO> obterTodosEventos() {
		
		ArrayList<EventoVO> listaEventosVO = new ArrayList<EventoVO>();
		
		for (Evento evento: eventoDao.obterTodosEventos()) {
			listaEventosVO.add(getEventoVO(evento));
		}
		
		return listaEventosVO;
	}

	@Override
	public EventoVO obterEventoPorId(Integer id) {
		return getEventoVO(eventoDao.obterEventoPorId(id));
	}

	
	private EventoVO getEventoVO(Evento evento){
		EventoVO eventoVO = new EventoVO();
		eventoVO.setId(evento.getId());
		eventoVO.setLatitude(evento.getLatitude());
		eventoVO.setLongitude(evento.getLongitude());
		eventoVO.setDataEvento(evento.getDataEvento());
		eventoVO.setDescricaoEvento(evento.getDescricaoEvento());
		eventoVO.setDescricaoEvento(evento.getDescricaoEvento());
		eventoVO.setNomeCidade(evento.getNomeCidade());
		eventoVO.setSiglaEstado(evento.getSiglaEstado());
		eventoVO.setNomeLogradouro(evento.getNomeLogradouro());
		eventoVO.setNumeroLogradouro(evento.getNumeroLogradouro());
		eventoVO.setTipoLogradouro(evento.getTipoLogradouro());
		eventoVO.setNumeroCep(evento.getNumeroCep());
		eventoVO.setUrlFoto(evento.getUrlFoto());
		return eventoVO;
	}
}
