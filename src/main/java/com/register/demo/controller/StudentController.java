package com.register.demo.controller;

import com.register.demo.Payload.Request.StudentPayload;
import com.register.demo.Payload.Response.CommonResponse;
import com.register.demo.entity.Students;
import com.register.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody StudentPayload studentPayload){
        studentService.addStudents(studentPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse("Student added successfully", HttpStatus.CREATED.value()));
    }


}
