package com.register.demo.controller;

import com.register.demo.Payload.Request.StudentPayload;
import com.register.demo.Payload.Response.CommonResponse;
import com.register.demo.entity.Students;
import com.register.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/add")
    public ResponseEntity addStudent(@RequestBody StudentPayload studentPayload){
        studentService.addStudents(studentPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse("Student added successfully", HttpStatus.CREATED.value()));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity updateStudent(@PathVariable("id") long id, @RequestBody StudentPayload studentPayload){
        studentService.updateStudent(id, studentPayload);
        return ResponseEntity.status(HttpStatus.OK.value()).body(new CommonResponse("Student update successfully", HttpStatus.OK.value()));
    }

    @GetMapping(path = "list")
    public ResponseEntity getAllStudents(){
        List<Students> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK.value()).body(students);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity getStudent(@PathVariable long id){
        Optional<Students> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not foumd with id " + id);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity DeleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(new CommonResponse("Student deleted successfully", HttpStatus.OK.value()));
    }
}
