package com.example.demo.resources;

import com.example.demo.dto.FileUploadDTO;
import com.example.demo.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class FileUploadResource {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/file/upload")
    public ResponseEntity<?> uploadCsv(@ModelAttribute FileUploadDTO file){
        try {
            log.info("*********************************************************"+file.getFile().getOriginalFilename());
            fileUploadService.parseAndSave(file);
        }catch (Exception e){

        }
        return new ResponseEntity<>("file uploaded successfully!",HttpStatus.OK);
    }
}
