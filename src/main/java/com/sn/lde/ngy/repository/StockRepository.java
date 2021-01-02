package com.sn.lde.ngy.repository;

import com.sn.lde.ngy.model.StockProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockProduit, Long> {
}
