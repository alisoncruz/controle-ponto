package com.company.controleponto.controller.form;

import com.company.controleponto.model.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UsuarioForm {

  @NotNull @NotEmpty CategoriaUsuario categoriaUsuario;
  @NotNull @NotEmpty private String nome;
  @NotNull @NotEmpty private Empresa empresa;
  @NotNull @NotEmpty private NivelAcesso nivelAcesso;
  @NotNull @NotEmpty private JornadaTrabalho jornadaTrabalho;
  @NotNull @NotEmpty private BigDecimal tolerancia;
  @NotNull @NotEmpty private LocalDateTime inicioJornada;
  @NotNull @NotEmpty private LocalDateTime finalJornada;

  public Usuario converter() {
    return Usuario.builder()
        .categoriaUsuario(this.categoriaUsuario)
        .nome(this.nome)
        .empresa(this.empresa)
        .nivelAcesso(this.nivelAcesso)
        .jornadaTrabalho(this.jornadaTrabalho)
        .tolerancia(this.tolerancia)
        .inicioJornada(this.inicioJornada)
        .finalJornada(this.finalJornada)
        .build();
  }

  public CategoriaUsuario getCategoriaUsuario() {
    return categoriaUsuario;
  }

  public String getNome() {
    return nome;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public NivelAcesso getNivelAcesso() {
    return nivelAcesso;
  }

  public JornadaTrabalho getJornadaTrabalho() {
    return jornadaTrabalho;
  }

  public BigDecimal getTolerancia() {
    return tolerancia;
  }

  public LocalDateTime getInicioJornada() {
    return inicioJornada;
  }

  public LocalDateTime getFinalJornada() {
    return finalJornada;
  }
}
