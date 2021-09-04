package com.company.controleponto.service;

import com.company.controleponto.model.TipoData;
import com.company.controleponto.repository.TipoDataRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDataService {

  TipoDataRepository tipoDataRepository;

  @Autowired
  public TipoDataService(TipoDataRepository tipoDataRepository) {
    this.tipoDataRepository = tipoDataRepository;
  }

  public List<TipoData> listar() {
    return this.tipoDataRepository.findAll();
  }

  public TipoData salvar(TipoData tipoData) {
    return tipoDataRepository.save(tipoData);
  }

  public TipoData buscar(Long id) {
    TipoData tipoData = tipoDataRepository.getById(id);
    if (tipoData == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return tipoData;
  }

  public TipoData atualizar(TipoData tipoData, Long codigo) {
    TipoData tipoDataOld = tipoDataRepository.getById(codigo);
    if (tipoDataOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(tipoData, tipoDataOld, "codigo");
    TipoData tipoDataAtualizada = tipoDataRepository.save(tipoDataOld);
    return tipoDataAtualizada;
  }

  public void remover(Long codigo) {
    TipoData tipoDataOld = tipoDataRepository.getById(codigo);
    if (tipoDataOld == null) throw new EmptyResultDataAccessException(1);
    tipoDataRepository.deleteById(codigo);
  }
}
