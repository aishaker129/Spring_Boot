package com.rest.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.bootrestbook.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUp;

    // @SuppressWarnings("null")
    @PostMapping("/upload_file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());
        // return ResponseEntity.ok("ok no error");

        try {

            // validation
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Request doesn't accepted because empty request is created");
            }

            //
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG file is allowed");
            }

            // where to upload the file on server: UPLOAD_DIR=

            // file upload

            boolean f = fileUp.uploadFile(file);

            if (f) {
                return ResponseEntity.ok("File is uploaded successfully");
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something want to wrong!.. try again..");
    }
}
