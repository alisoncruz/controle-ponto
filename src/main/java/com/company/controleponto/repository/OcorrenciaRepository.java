package com.company.controleponto.repository;

import com.company.controleponto.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia,Long> {
}
