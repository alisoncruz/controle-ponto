package com.company.controleponto.controller.dto;

import com.company.controleponto.model.Ocorrencia;

import java.util.List;
import java.util.stream.Collectors;

public class OcorrenciaDTO {
  private Long id;

  private String descricao;

  private String nome;

  public OcorrenciaDTO(Ocorrencia ocorrencia) {
    this.id = ocorrencia.getId();
    this.descricao = ocorrencia.getDescricao();
    this.nome = ocorrencia.getNome();
  }

  public static List<OcorrenciaDTO> listaDTO(List<Ocorrencia> lista) {
    return lista.stream()
        .map(Ocorrencia -> new OcorrenciaDTO(Ocorrencia))
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
