package com.company.controleponto.controller.form;

import com.company.controleponto.model.CategoriaUsuario;
import com.company.controleponto.model.TipoData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoriaUsuarioForm {

  @NotNull
  @NotEmpty
  @Size(min = 5, max = 10)
  private String descricao;

  public CategoriaUsuario converter() {
    return CategoriaUsuario.builder().descricao(descricao).build();
  }

  public String getDescricao() {
    return descricao;
  }
}
