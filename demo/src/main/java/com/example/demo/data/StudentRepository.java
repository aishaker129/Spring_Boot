package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Student findById(int id);
}
