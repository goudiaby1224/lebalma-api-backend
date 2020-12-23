package com.sn.lde.ngy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sn.lde.ngy.model.EmployePartenaire;

import java.util.List;

public interface EmployeRepository extends JpaRepository<EmployePartenaire, Long> {

    List<EmployePartenaire> findByPartenaireId(long parternaireId);

}
