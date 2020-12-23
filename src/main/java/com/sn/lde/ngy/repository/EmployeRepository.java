package com.sn.lde.ngy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sn.lde.ngy.model.Employe;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findByPartenaireId(long parternaireId);

}
