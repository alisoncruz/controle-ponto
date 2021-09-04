package com.company.controleponto.repository;

import com.company.controleponto.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHoras.BancoHorasId> {
}
