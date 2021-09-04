package com.company.controleponto.controller.dto;

import com.company.controleponto.model.NivelAcesso;

import java.util.List;
import java.util.stream.Collectors;

public class NivelAcessoDTO {
  private Long id;

  private String descricao;

  public NivelAcessoDTO(NivelAcesso nivelAcesso) {
    this.id = nivelAcesso.getId();
    this.descricao = nivelAcesso.getDescricao();
  }

  public static List<NivelAcessoDTO> listaDTO(List<NivelAcesso> lista) {
    return lista.stream()
        .map(nivelAcesso -> new NivelAcessoDTO(nivelAcesso))
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
