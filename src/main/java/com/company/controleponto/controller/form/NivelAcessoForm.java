package com.company.controleponto.controller.form;

import com.company.controleponto.model.NivelAcesso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NivelAcessoForm {

  @NotNull
  @NotEmpty
  @Size(min = 5, max = 10)
  private String descricao;

  public NivelAcesso converter() {
    return NivelAcesso.builder().descricao(descricao).build();
  }

  public String getDescricao() {
    return descricao;
  }
}
