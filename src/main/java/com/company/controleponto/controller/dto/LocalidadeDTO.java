package com.company.controleponto.controller.dto;

import com.company.controleponto.model.Empresa;
import com.company.controleponto.model.Localidade;
import com.company.controleponto.model.NivelAcesso;

import java.util.List;
import java.util.stream.Collectors;

public class LocalidadeDTO {
  private Long id;
  private NivelAcessoDTO nivelAcesso;
  private String descricao;

  public LocalidadeDTO(Localidade localidade) {
    this.nivelAcesso = new NivelAcessoDTO(localidade.getNivelAcesso());
    this.descricao = localidade.getDescricao();
    this.id = localidade.getId();
  }

  public static List<LocalidadeDTO> listaDTO(List<Localidade> lista) {
    return lista.stream()
        .map(localidade -> new LocalidadeDTO(localidade))
        .collect(Collectors.toList());
  }

  public NivelAcessoDTO getNivelAcesso() {
    return nivelAcesso;
  }

  public void setNivelAcesso(NivelAcessoDTO nivelAcesso) {
    this.nivelAcesso = nivelAcesso;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
