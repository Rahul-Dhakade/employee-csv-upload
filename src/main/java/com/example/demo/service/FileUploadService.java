package com.example.demo.service;

import com.example.demo.domain.Employees;
import com.example.demo.dto.FileUploadDTO;
import com.example.demo.repository.EmployeesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
@Slf4j
public class FileUploadService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public void parseAndSave(FileUploadDTO file){
        log.info("parse csv file and save data into DB");
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader( file.getFile().getInputStream()) );
            while( (line = bufferedReader.readLine()) != null ) {
                log.info("employee {}",line);
                String[] emps = line.split(",");
                employeesRepository.save(new Employees(emps[0],emps[1],emps[2]));
            }
        }catch (Exception e){
            log.error("error occurred while storing data to DB");
        }
    }
}
