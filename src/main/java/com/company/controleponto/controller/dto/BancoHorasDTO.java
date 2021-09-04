package com.company.controleponto.controller.dto;

import com.company.controleponto.model.BancoHoras;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BancoHorasDTO {

  private Long idBancoHoras;
  private Long idMovimento;
  private Long idUsuario;
  private LocalDateTime dataTrabalhada;
  private BigDecimal quantidadeHoras;
  private BigDecimal saldoHoras;

  public BancoHorasDTO(BancoHoras bancoHoras) {
    this.idBancoHoras = bancoHoras.getBancoHorasId().getIdBancoHoras();
    this.idMovimento = bancoHoras.getBancoHorasId().getIdMovimento();
    this.idUsuario = bancoHoras.getBancoHorasId().getIdUsuario();
    this.dataTrabalhada = bancoHoras.getDataTrabalhada();
    this.quantidadeHoras = bancoHoras.getQuantidadeHoras();
    this.saldoHoras = bancoHoras.getSaldoHoras();
  }

  public static List<BancoHorasDTO> listaDTO(List<BancoHoras> lista) {
    return lista.stream()
        .map(bancoHoras -> new BancoHorasDTO(bancoHoras))
        .collect(Collectors.toList());
  }

  public Long getIdBancoHoras() {
    return idBancoHoras;
  }

  public void setIdBancoHoras(Long idBancoHoras) {
    this.idBancoHoras = idBancoHoras;
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

  public LocalDateTime getDataTrabalhada() {
    return dataTrabalhada;
  }

  public void setDataTrabalhada(LocalDateTime dataTrabalhada) {
    this.dataTrabalhada = dataTrabalhada;
  }

  public BigDecimal getQuantidadeHoras() {
    return quantidadeHoras;
  }

  public void setQuantidadeHoras(BigDecimal quantidadeHoras) {
    this.quantidadeHoras = quantidadeHoras;
  }

  public BigDecimal getSaldoHoras() {
    return saldoHoras;
  }

  public void setSaldoHoras(BigDecimal saldoHoras) {
    this.saldoHoras = saldoHoras;
  }
}
