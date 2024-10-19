package com.cicd.demo.ci_cd.Controller;

import com.cicd.demo.ci_cd.Exception.StudentException;
import com.cicd.demo.ci_cd.enitity.Student;
import com.cicd.demo.ci_cd.repo.StudentImpl;
import com.cicd.demo.ci_cd.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentImpl studentImpl;

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        Student student1 = studentImpl.setStudent(student);
        return student1;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> allStudents = studentImpl.getAllStudents();
        return allStudents;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student student){
        Student student1 = studentImpl.updateStudent(id, student);
        return ResponseEntity.ok(student1);
    }


    @PatchMapping("/updatePartial/{id}")
    public ResponseEntity<Student> updatePartialStudent(@PathVariable int id,@RequestBody Map<String,Object> student){
        try{
            Student student1=studentImpl.updatePartialStudent(id,student);
            return ResponseEntity.ok(student1);
        }
        catch (StudentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        String s = studentImpl.deleteStudent(id);
        return "Deleted student of id->"+id;
    }


}
