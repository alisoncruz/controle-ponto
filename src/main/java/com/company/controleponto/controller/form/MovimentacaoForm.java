package com.company.controleponto.controller.form;

import com.company.controleponto.model.BancoHoras;
import com.company.controleponto.model.Calendario;
import com.company.controleponto.model.Movimentacao;
import com.company.controleponto.model.Ocorrencia;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimentacaoForm {
  @NotNull @NotEmpty private Long idMovimento;
  @NotNull @NotEmpty private Long idUsuario;
  @NotNull @NotEmpty private LocalDateTime dataEntrada;
  @NotNull @NotEmpty private LocalDateTime dataSaida;
  @NotNull @NotEmpty private BigDecimal periodo;
  @NotNull @NotEmpty private Ocorrencia ocorrencia;
  @NotNull @NotEmpty private Calendario calendario;

  public Movimentacao converter() {
    Movimentacao movimentacao = new Movimentacao();
    movimentacao.getId().setIdUsuario(idUsuario);
    movimentacao.getId().setIdMovimento(idMovimento);
    movimentacao.setDataEntrada(this.dataEntrada);
    movimentacao.setPeriodo(this.periodo);
    movimentacao.setOcorrencia(this.ocorrencia);
    movimentacao.setCalendario(this.calendario);
    return movimentacao;
  }

  public Long getIdMovimento() {
    return idMovimento;
  }

  public void setIdMovimento(Long idMovimento) {
    this.idMovimento = idMovimento;
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
  }

  public LocalDateTime getDataEntrada() {
    return dataEntrada;
  }

  public void setDataEntrada(LocalDateTime dataEntrada) {
    this.dataEntrada = dataEntrada;
  }

  public LocalDateTime getDataSaida() {
    return dataSaida;
  }

  public void setDataSaida(LocalDateTime dataSaida) {
    this.dataSaida = dataSaida;
  }

  public BigDecimal getPeriodo() {
    return periodo;
  }

  public void setPeriodo(BigDecimal periodo) {
    this.periodo = periodo;
  }

  public Ocorrencia getOcorrencia() {
    return ocorrencia;
  }

  public void setOcorrencia(Ocorrencia ocorrencia) {
    this.ocorrencia = ocorrencia;
  }

  public Calendario getCalendario() {
    return calendario;
  }

  public void setCalendario(Calendario calendario) {
    this.calendario = calendario;
  }
}
