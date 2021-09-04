package com.company.controleponto.repository;

import com.company.controleponto.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
