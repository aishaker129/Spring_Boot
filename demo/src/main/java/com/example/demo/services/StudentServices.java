package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.data.StudentRepository;
import com.example.demo.entity.Student;

@Component
public class StudentServices {
    // public String home() {
    //     return "This is home page";
    // }

    @Autowired
    private StudentRepository studentRepository;

    // public static List<Student> list = new ArrayList<>();
   
    // static {
    //     list.add(new Student(1, "Ai Shaker", "CSE", 49, 9, 2022));
    //     list.add(new Student(2, "Shaker", "CSE", 49, 9, 2022));
    //     list.add(new Student(3, "Mahfuz Mia", "CSE", 49, 9, 2022));
    //     list.add(new Student(4, "Rifatul Islam", "CSE", 49, 9, 2022));
    //     list.add(new Student(5, "Ali Akbor", "CSE", 49, 9, 2022));
    //     list.add(new Student(6, "Rafiul Islam", "CSE", 49, 9, 2022));
    // }
    
    public List<Student> getAllStudent() {
        // return list;
        List<Student> list = (List<Student>) this.studentRepository.findAll();
        return list;
    }

    public Student getstudentById(int id) {
        // Student std = list.stream().filter(e -> e.getId() == id).findFirst().get();
        // return std;
        Student std = this.studentRepository.findById(id);
        return std;
    }

    public Student addStudent(Student std) {
        // list.add(std);
        // return std;
        this.studentRepository.save(std);
        return std;
    }

    public Student deletestudent(int id) {
        // Student std = list.stream().filter(e -> e.getId() == id).findFirst().get();
        // list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
        // return std;
        Student std = this.studentRepository.findById(id);
        this.studentRepository.deleteById(id);
        return std;
    }

    public void modify(Student std, int id) {
        // list = list.stream().map(e->{
        //     if(e.getId()==id){
        //         e.setName(std.getName());
        //         e.setDept(std.getDept());
        //         e.setIntake(std.getIntake());
        //         e.setSection(std.getSection());
        //         e.setSassion(std.getSassion());
        //     }
        //     return e;
        // }).collect(Collectors.toList());

        std.setId(id);
        this.studentRepository.save(std);
    }

}

