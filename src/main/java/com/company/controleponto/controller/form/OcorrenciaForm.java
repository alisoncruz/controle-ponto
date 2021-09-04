package com.company.controleponto.controller.form;

import com.company.controleponto.model.Ocorrencia;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OcorrenciaForm {

  @NotNull
  @NotEmpty
  @Size(min = 5, max = 10)
  private String nome;

  @NotNull
  @NotEmpty
  @Size(min = 5, max = 10)
  private String descricao;

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public Ocorrencia converter() {
    return Ocorrencia.builder().descricao(descricao).nome(this.nome).build();
  }
}
