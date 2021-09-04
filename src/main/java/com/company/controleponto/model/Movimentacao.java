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
public class Movimentacao {

  @Embeddable
  @AllArgsConstructor
  @NoArgsConstructor
  @EqualsAndHashCode
  @Getter
  @Setter
  public static class MovimentacaoId implements Serializable {

    private Long idMovimento;

    private Long idUsuario;
  }

  @EmbeddedId private MovimentacaoId id;

  private LocalDateTime dataEntrada;
  private LocalDateTime dataSaida;
  private BigDecimal periodo;
  @ManyToOne private Ocorrencia ocorrencia;
  @ManyToOne private Calendario calendario;
}
