package com.company.controleponto.service;

import com.company.controleponto.model.BancoHoras;
import com.company.controleponto.repository.BancoHorasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoHorasService {
  BancoHorasRepository bancoHorasRepository;

  @Autowired
  public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
    this.bancoHorasRepository = bancoHorasRepository;
  }

  public List<BancoHoras> listar() {
    return this.bancoHorasRepository.findAll();
  }

  public BancoHoras salvar(BancoHoras bancoHoras) {
    return bancoHorasRepository.save(bancoHoras);
  }

  public BancoHoras buscar(BancoHoras.BancoHorasId id) {
    BancoHoras bancoHoras = bancoHorasRepository.getById(id);
    if (bancoHoras == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return bancoHoras;
  }

  public BancoHoras atualizar(BancoHoras bancoHoras, BancoHoras.BancoHorasId codigo) {
    BancoHoras bancoHorasOld = bancoHorasRepository.getById(codigo);
    if (bancoHorasOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(bancoHoras, bancoHorasOld, "codigo");
    BancoHoras bancoHorasAtualizada = bancoHorasRepository.save(bancoHorasOld);
    return bancoHorasAtualizada;
  }

  public void remover(BancoHoras.BancoHorasId codigo) {
    BancoHoras bancoHorasOld = bancoHorasRepository.getById(codigo);
    if (bancoHorasOld == null) throw new EmptyResultDataAccessException(1);
    bancoHorasRepository.deleteById(codigo);
  }
}
