package com.company.controleponto.model;

import com.company.controleponto.model.embedded.Endereco;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String descricao;
    private String cnpj;
    @Embedded
    private Endereco endereco;
    private String telefone;
}
