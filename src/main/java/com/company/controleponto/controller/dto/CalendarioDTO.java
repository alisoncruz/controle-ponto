package com.company.controleponto.controller.dto;

import com.company.controleponto.model.Calendario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarioDTO {
  private Long id;
  private TipoDataDTO tipoData;
  private String descricao;
  private LocalDateTime dataEspecial;

  public CalendarioDTO(Calendario calendario) {
    this.id = calendario.getId();
    this.tipoData = new TipoDataDTO(calendario.getTipoData());
    this.descricao = calendario.getDescricao();
    this.dataEspecial = calendario.getDataEspecial();
  }

  public static List<CalendarioDTO> listaDTO(List<Calendario> lista) {
    return lista.stream()
        .map(calendario -> new CalendarioDTO(calendario))
        .collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TipoDataDTO getTipoData() {
    return tipoData;
  }

  public void setTipoData(TipoDataDTO tipoData) {
    this.tipoData = tipoData;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDateTime getDataEspecial() {
    return dataEspecial;
  }

  public void setDataEspecial(LocalDateTime dataEspecial) {
    this.dataEspecial = dataEspecial;
  }
}
