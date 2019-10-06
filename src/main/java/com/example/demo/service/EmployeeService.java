package com.example.demo.service;

import com.example.demo.domain.Employees;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees getEmployee(Long id){
        return employeesRepository.findOne(id);
    }

    public List<Employees> getEmployees(){
        return employeesRepository.findAll();
    }

    public Employees createEmployees(EmployeeDTO employeeDTO){
        return employeesRepository.save(new Employees(employeeDTO.getFirstName(),
                employeeDTO.getLastName(),employeeDTO.getEmail()));
    }

    public Employees updateEmployees(EmployeeDTO employeeDTO){
        Employees employee = employeesRepository.findOne(employeeDTO.getId());
        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        return employeesRepository.save(employee);
    }

    public void deleteEmployees(Long id){
        employeesRepository.deleteById(id);
    }


}
