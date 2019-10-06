package com.example.demo.repository;

import com.example.demo.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {
    Employees findOne(Long id);

    List<Employees> findAll();
}
