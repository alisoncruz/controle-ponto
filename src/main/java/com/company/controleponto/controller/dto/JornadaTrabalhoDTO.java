package com.company.controleponto.controller.dto;

import com.company.controleponto.model.JornadaTrabalho;

import java.util.List;
import java.util.stream.Collectors;

public class JornadaTrabalhoDTO {

  private Long id;
  private String descricao;

  public JornadaTrabalhoDTO(JornadaTrabalho jornada) {
    this.id = jornada.getId();
    this.descricao = jornada.getDescricao();
  }

  public static List<JornadaTrabalhoDTO> listaDTO(List<JornadaTrabalho> listaJornada) {
    return listaJornada.stream()
        .map(jornadaTrabalho -> new JornadaTrabalhoDTO(jornadaTrabalho))
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
