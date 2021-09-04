package com.company.controleponto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class BancoHoras {

  @Embeddable
  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  public static class BancoHorasId implements Serializable {
    private Long idBancoHoras;
    private Long idMovimento;
    private Long idUsuario;
  }

  @EmbeddedId private BancoHorasId bancoHorasId;
  private LocalDateTime dataTrabalhada;
  private BigDecimal quantidadeHoras;
  private BigDecimal saldoHoras;
}
