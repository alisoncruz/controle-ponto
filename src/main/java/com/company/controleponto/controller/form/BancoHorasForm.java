package com.company.controleponto.controller.form;

import com.company.controleponto.model.BancoHoras;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BancoHorasForm {

  @NotNull @NotEmpty private Long idMovimento;
  @NotNull @NotEmpty private Long idUsuario;
  @NotNull @NotEmpty private LocalDateTime dataTrabalhada;
  @NotNull @NotEmpty private BigDecimal quantidadeHoras;
  @NotNull @NotEmpty private BigDecimal saldoHoras;

  public BancoHoras converter() {
    BancoHoras bancoHoras = new BancoHoras();
    bancoHoras.getBancoHorasId().setIdMovimento(this.idMovimento);
    bancoHoras.getBancoHorasId().setIdUsuario(this.idUsuario);
    bancoHoras.setDataTrabalhada(this.dataTrabalhada);
    bancoHoras.setQuantidadeHoras(this.quantidadeHoras);
    bancoHoras.setSaldoHoras(this.saldoHoras);
    return bancoHoras;
  }

  public Long getIdMovimento() {
    return idMovimento;
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public LocalDateTime getDataTrabalhada() {
    return dataTrabalhada;
  }

  public BigDecimal getQuantidadeHoras() {
    return quantidadeHoras;
  }

  public BigDecimal getSaldoHoras() {
    return saldoHoras;
  }
}
