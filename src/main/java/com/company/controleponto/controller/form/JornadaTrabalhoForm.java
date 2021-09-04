package com.company.controleponto.controller.form;

import com.company.controleponto.model.JornadaTrabalho;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JornadaTrabalhoForm {

  @NotNull
  @NotEmpty
  @Size(min = 2, max = 10)
  private String descricao;

  public String getDescricao() {
    return descricao;
  }

  public JornadaTrabalho converter() {
    return JornadaTrabalho.builder().descricao(this.descricao).build();
  }
}
