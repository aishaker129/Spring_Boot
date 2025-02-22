package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_data")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String dept;
    private int intake;
    private int section;
    private int sassion;
    public Student(int id, String name, String dept, int intake, int section, int sassion) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.intake = intake;
        this.section = section;
        this.sassion = sassion;
    }
    public Student() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public int getIntake() {
        return intake;
    }
    public void setIntake(int intake) {
        this.intake = intake;
    }
    public int getSection() {
        return section;
    }
    public void setSection(int section) {
        this.section = section;
    }
    public int getSassion() {
        return sassion;
    }
    public void setSassion(int sassion) {
        this.sassion = sassion;
    }
    @Override
    public String toString() {
        return "Studdent [id=" + id + ", name=" + name + ", dept=" + dept + ", intake=" + intake + ", section="
                + section + ", sassion=" + sassion + "]";
    }

    
}
