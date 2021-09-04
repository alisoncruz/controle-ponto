package com.company.controleponto.controller.form;

import com.company.controleponto.controller.dto.TipoDataDTO;
import com.company.controleponto.model.Calendario;
import com.company.controleponto.model.TipoData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CalendarioForm {
  @NotNull @NotEmpty private TipoData tipoData;
  @NotNull @NotEmpty private String descricao;
  @NotNull @NotEmpty private LocalDateTime dataEspecial;

  public Calendario converter() {
    return Calendario.builder()
        .tipoData(this.tipoData)
        .descricao(this.descricao)
        .dataEspecial(this.dataEspecial)
        .build();
  }

  public TipoData getTipoData() {
    return tipoData;
  }

  public String getDescricao() {
    return descricao;
  }

  public LocalDateTime getDataEspecial() {
    return dataEspecial;
  }
}
