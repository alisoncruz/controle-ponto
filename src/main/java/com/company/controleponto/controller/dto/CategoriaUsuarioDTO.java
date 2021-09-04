package com.company.controleponto.controller.dto;

import com.company.controleponto.model.CategoriaUsuario;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaUsuarioDTO {
  private Long id;

  private String descricao;

  public CategoriaUsuarioDTO(CategoriaUsuario categoria) {
    this.id = categoria.getId();
    this.descricao = categoria.getDescricao();
  }

  public static List<CategoriaUsuarioDTO> listaDTO(List<CategoriaUsuario> lista) {
    return lista.stream()
        .map(categoria -> new CategoriaUsuarioDTO(categoria))
        .collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
