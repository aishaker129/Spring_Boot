package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class studentController {

    @Autowired
    private StudentServices studentServices;
    
    // @RequestMapping(value = "/home", method = RequestMethod.GET)
    // @ResponseBody
    // public String home() {
    //     return "This is home page";
    // }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent() {
       
        try {
            List<Student> std = this.studentServices.getAllStudent();
            return ResponseEntity.status(HttpStatus.FOUND).body(std);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        
        try {
            Student std = this.studentServices.getstudentById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(std);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student std) {
        try {
            Student student = this.studentServices.addStudent(std);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
        try {
            Student std = this.studentServices.deletestudent(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(std);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student>  updateStudent(@PathVariable("id") int id, @RequestBody Student entity) {
        try {
            this.studentServices.modify(entity, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    
}
