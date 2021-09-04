package com.company.controleponto.repository;

import com.company.controleponto.model.NivelAcesso;
import com.company.controleponto.model.TipoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDataRepository extends JpaRepository<TipoData, Long> {
}
