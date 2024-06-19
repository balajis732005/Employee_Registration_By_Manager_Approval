package com.balajiscode.Backend_Register_By_manager.repository;

import com.balajiscode.Backend_Register_By_manager.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Long> {

}
