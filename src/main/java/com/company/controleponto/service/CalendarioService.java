package com.company.controleponto.service;

import com.company.controleponto.model.Calendario;
import com.company.controleponto.repository.CalendarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioService {
  CalendarioRepository calendarioRepository;

  @Autowired
  public CalendarioService(CalendarioRepository calendarioRepository) {
    this.calendarioRepository = calendarioRepository;
  }

  public List<Calendario> listar() {
    return this.calendarioRepository.findAll();
  }

  public Calendario salvar(Calendario calendario) {
    return calendarioRepository.save(calendario);
  }

  public Calendario buscar(Long id) {
    Calendario calendario = calendarioRepository.getById(id);
    if (calendario == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return calendario;
  }

  public Calendario atualizar(Calendario calendario, Long codigo) {
    Calendario calendarioOld = calendarioRepository.getById(codigo);
    if (calendarioOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(calendario, calendarioOld, "codigo");
    Calendario calendarioAtualizado = calendarioRepository.save(calendarioOld);
    return calendarioAtualizado;
  }

  public void remover(Long codigo) {
    Calendario calendarioOld = calendarioRepository.getById(codigo);
    if (calendarioOld == null) throw new EmptyResultDataAccessException(1);
    calendarioRepository.deleteById(codigo);
  }
}
