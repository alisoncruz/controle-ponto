package com.company.controleponto.controller.dto;

import com.company.controleponto.model.TipoData;

import java.util.List;
import java.util.stream.Collectors;

public class TipoDataDTO {
  private Long id;

  private String descricao;

  public TipoDataDTO(TipoData tipoData) {
    this.id = tipoData.getId();
    this.descricao = tipoData.getDescricao();
  }

  public static List<TipoDataDTO> listaDTO(List<TipoData> lista) {
    return lista.stream().map(tipoData -> new TipoDataDTO(tipoData)).collect(Collectors.toList());
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
