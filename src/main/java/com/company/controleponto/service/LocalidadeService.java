package com.company.controleponto.service;

import com.company.controleponto.model.Localidade;
import com.company.controleponto.repository.LocalidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeService {

  LocalidadeRepository localidadeRepository;

  @Autowired
  public LocalidadeService(LocalidadeRepository localidadeRepository) {
    this.localidadeRepository = localidadeRepository;
  }

  public List<Localidade> listar() {
    return this.localidadeRepository.findAll();
  }

  public Localidade salvar(Localidade localidade) {
    return localidadeRepository.save(localidade);
  }

  public Localidade buscar(Long id) {
    Localidade localidade = localidadeRepository.getById(id);
    if (localidade == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return localidade;
  }

  public Localidade atualizar(Localidade localidade, Long codigo) {
    Localidade localidadeOld = localidadeRepository.getById(codigo);
    if (localidadeOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(localidade, localidadeOld, "codigo");
    Localidade localidadeAtualizada = localidadeRepository.save(localidadeOld);
    return localidadeAtualizada;
  }

  public void remover(Long codigo) {
    Localidade localidadeOld = localidadeRepository.getById(codigo);
    if (localidadeOld == null) throw new EmptyResultDataAccessException(1);
    localidadeRepository.deleteById(codigo);
  }
}
