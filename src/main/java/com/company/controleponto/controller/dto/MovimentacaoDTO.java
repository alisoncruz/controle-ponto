package com.company.controleponto.controller.dto;

import com.company.controleponto.model.Calendario;
import com.company.controleponto.model.Movimentacao;
import com.company.controleponto.model.Ocorrencia;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MovimentacaoDTO {

  private Long idMovimento;
  private Long idUsuario;
  private LocalDateTime dataEntrada;
  private LocalDateTime dataSaida;
  private BigDecimal periodo;
  private OcorrenciaDTO ocorrencia;
  private CalendarioDTO calendario;

  public MovimentacaoDTO(Movimentacao movimentacao) {
    this.idMovimento = movimentacao.getId().getIdMovimento();
    this.idUsuario = movimentacao.getId().getIdUsuario();
    this.dataEntrada = movimentacao.getDataEntrada();
    this.dataSaida = movimentacao.getDataSaida();
    this.periodo = movimentacao.getPeriodo();
    this.ocorrencia = new OcorrenciaDTO(movimentacao.getOcorrencia());
    this.calendario = new CalendarioDTO(movimentacao.getCalendario());
  }

  public static List<MovimentacaoDTO> listaDTO(List<Movimentacao> lista) {
    return lista.stream()
        .map(movimentacao -> new MovimentacaoDTO(movimentacao))
        .collect(Collectors.toList());
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

  public OcorrenciaDTO getOcorrencia() {
    return ocorrencia;
  }

  public void setOcorrencia(OcorrenciaDTO ocorrencia) {
    this.ocorrencia = ocorrencia;
  }

  public CalendarioDTO getCalendario() {
    return calendario;
  }

  public void setCalendario(CalendarioDTO calendario) {
    this.calendario = calendario;
  }
}
