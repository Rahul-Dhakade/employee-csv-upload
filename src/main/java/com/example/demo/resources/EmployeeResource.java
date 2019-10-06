package com.example.demo.resources;

import com.example.demo.domain.Employees;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emps/{id}")
    public ResponseEntity<?> getEmps(@PathVariable Long id){
        Employees employees = employeeService.getEmployee(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/emps")
    public ResponseEntity<?> getEmps(){
        List<Employees> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/emps")
    public ResponseEntity<?> createEmps(@RequestBody EmployeeDTO employeeDTO){
        Employees employees = employeeService.createEmployees(employeeDTO);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    @PutMapping("/emps")
    public ResponseEntity<?> updateEmps(@RequestBody EmployeeDTO employeeDTO){
        Employees employees = employeeService.updateEmployees(employeeDTO);
        return new ResponseEntity<>(employees, HttpStatus.ACCEPTED);
    }

    @PutMapping("/emps/{id}")
    public ResponseEntity<?> deleteEmps(@PathVariable Long id){
        employeeService.deleteEmployees(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
