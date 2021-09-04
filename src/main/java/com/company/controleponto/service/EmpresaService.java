package com.company.controleponto.service;

import com.company.controleponto.model.Empresa;
import com.company.controleponto.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaService {

  EmpresaRepository empresaRepository;

  @Autowired
  public EmpresaService(EmpresaRepository empresaRepository) {
    this.empresaRepository = empresaRepository;
  }

  public List<Empresa> listar() {
    return this.empresaRepository.findAll();
  }

  public Empresa salvar(Empresa empresa) {
    return empresaRepository.save(empresa);
  }

  public Empresa buscar(Long id) {
    Empresa empresa = empresaRepository.getById(id);
    if (empresa == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return empresa;
  }

  public Empresa atualizar(Empresa empresa, Long codigo) {
    Empresa empresaOld = empresaRepository.getById(codigo);
    if (empresaOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(empresa, empresaOld, "codigo");
    Empresa empresaAtualizada = empresaRepository.save(empresaOld);
    return empresaAtualizada;
  }

  public void remover(Long codigo) {
    Empresa empresaOld = empresaRepository.getById(codigo);
    if (empresaOld == null) throw new EmptyResultDataAccessException(1);
    empresaRepository.deleteById(codigo);
  }
}
