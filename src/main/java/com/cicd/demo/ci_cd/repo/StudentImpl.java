package com.cicd.demo.ci_cd.repo;

import com.cicd.demo.ci_cd.Exception.StudentException;
import com.cicd.demo.ci_cd.enitity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl {

    @Autowired
    private StudentRepo studentRepo;

    public Student setStudent(Student st){
        Student saveSt = studentRepo.save(st);
        return saveSt;
    }

    public List<Student> getAllStudents(){
        List<Student> allSt = studentRepo.findAll();
        return allSt;
    }

    public Student updateStudent(int id,Student oldStu){
        Student student = studentRepo.findById(id).orElseThrow(()->new StudentException("Student Not Found"));

            student.setStudentName(oldStu.getStudentName());
            student.setStudentRollNumber(oldStu.getStudentRollNumber());
            student.setStudentEmail(oldStu.getStudentEmail());
            student.setStudentBooks(oldStu.getStudentBooks());
            Student savedStu = studentRepo.save(student);
            return savedStu;
    }

    public String deleteStudent(int id){
        Student stu = studentRepo.findById(id).orElseThrow(()->new StudentException("Student Not Found"));
        studentRepo.delete(stu);
        return "Student Deleted";
    }
}
