package com.cicd.demo.ci_cd.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String studentName;
    private int studentRollNumber;
    private String studentEmail;
    private List<String> studentBooks;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(int studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public List<String> getStudentBooks() {
        return studentBooks;
    }

    public void setStudentBooks(List<String> studentBooks) {
        this.studentBooks = studentBooks;
    }

    private Student(){

    }

    public Student(int id, String studentName, int studentRollNumber, String studentEmail, List<String> studentBooks) {
        Id = id;
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.studentEmail = studentEmail;
        this.studentBooks = studentBooks;
    }
}
