package com.company.controleponto.repository;

import com.company.controleponto.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Movimentacao.MovimentacaoId> {
}
