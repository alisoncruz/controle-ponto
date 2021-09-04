package com.company.controleponto.controller.form;

import com.company.controleponto.model.TipoData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TipoDataForm {

  @NotNull
  @NotEmpty
  @Size(min = 5, max = 10)
  private String descricao;

  public TipoData converter() {
    return TipoData.builder().descricao(descricao).build();
  }

  public String getDescricao() {
    return descricao;
  }
}
