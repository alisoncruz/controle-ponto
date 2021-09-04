package com.company.controleponto.service;

import com.company.controleponto.model.CategoriaUsuario;
import com.company.controleponto.repository.CategoriaUsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUsuarioService {

  CategoriaUsuarioRepository categoriaRepository;

  @Autowired
  public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  public List<CategoriaUsuario> listar() {
    return this.categoriaRepository.findAll();
  }

  public CategoriaUsuario salvar(CategoriaUsuario categoria) {
    return categoriaRepository.save(categoria);
  }

  public CategoriaUsuario buscar(Long id) {
    CategoriaUsuario categoria = categoriaRepository.getById(id);
    if (categoria == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return categoria;
  }

  public CategoriaUsuario atualizar(CategoriaUsuario categoria, Long codigo) {
    CategoriaUsuario categoriaOld = categoriaRepository.getById(codigo);
    if (categoriaOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(categoria, categoriaOld, "codigo");
    CategoriaUsuario categoriaAtualizada = categoriaRepository.save(categoriaOld);
    return categoriaAtualizada;
  }

  public void remover(Long codigo) {
    CategoriaUsuario categoriaOld = categoriaRepository.getById(codigo);
    if (categoriaOld == null) throw new EmptyResultDataAccessException(1);
    categoriaRepository.deleteById(codigo);
  }
}
