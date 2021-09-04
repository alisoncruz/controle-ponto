package com.company.controleponto.controller.form;

import com.company.controleponto.model.Localidade;
import com.company.controleponto.model.NivelAcesso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LocalidadeForm {

  @NotNull @NotEmpty private NivelAcesso nivelAcesso;
  @NotNull @NotEmpty private String descricao;

  public Localidade converter() {
    return Localidade.builder().nivelAcesso(this.nivelAcesso).descricao(this.descricao).build();
  }

  public NivelAcesso getNivelAcesso() {
    return nivelAcesso;
  }

  public String getDescricao() {
    return descricao;
  }
}
