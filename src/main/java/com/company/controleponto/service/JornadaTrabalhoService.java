package com.company.controleponto.service;

import com.company.controleponto.model.JornadaTrabalho;
import com.company.controleponto.repository.JornadaRepository;
import org.hibernate.envers.Audited;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaTrabalhoService {

  private JornadaRepository jornadaRepository;

  @Autowired
  public JornadaTrabalhoService(JornadaRepository jornadaRepository) {
    this.jornadaRepository = jornadaRepository;
  }

  public List<JornadaTrabalho> listar() {
    return this.jornadaRepository.findAll();
  }

  public JornadaTrabalho salvar(JornadaTrabalho jornadaTrabalho) {
    return jornadaRepository.save(jornadaTrabalho);
  }

  public JornadaTrabalho buscar(Long id) {
    JornadaTrabalho jornadaTrabalho = jornadaRepository.getById(id);
    if (jornadaTrabalho == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return jornadaTrabalho;
  }

  public JornadaTrabalho atualizar(JornadaTrabalho jornadaTrabalho, Long codigo) {
    JornadaTrabalho jornadaTrabalhoOld = jornadaRepository.getById(codigo);
    if (jornadaTrabalhoOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(jornadaTrabalho, jornadaTrabalhoOld, "codigo");
    JornadaTrabalho jornadaAtualizada = jornadaRepository.save(jornadaTrabalhoOld);
    return jornadaAtualizada;
  }

  public void remover(Long codigo) {
    JornadaTrabalho jornadaTrabalhoOld = jornadaRepository.getById(codigo);
    if (jornadaTrabalhoOld == null) throw new EmptyResultDataAccessException(1);
    jornadaRepository.deleteById(codigo);
  }
}
