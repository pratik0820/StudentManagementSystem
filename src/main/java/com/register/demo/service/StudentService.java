package com.register.demo.service;

import com.register.demo.Payload.Request.StudentPayload;
import com.register.demo.Repository.StudentRepository;
import com.register.demo.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudents(StudentPayload studentPayload){
        Students students = new Students();
        students.setRollNo(studentPayload.getRollNo());
        students.setFirstName(studentPayload.getFirstName());
        students.setLastName(studentPayload.getLastName());
        students.setDateOfBirth(studentPayload.getDateOfBirth());
        students.setGender(studentPayload.getGender());
        students.setStatus(studentPayload.getStatus());

       studentRepository.save(students);
    }
}
