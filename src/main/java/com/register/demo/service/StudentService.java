package com.register.demo.service;

import com.register.demo.Payload.Request.StudentPayload;
import com.register.demo.Repository.StudentRepository;
import com.register.demo.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateStudent(long id, StudentPayload studentPayload) {
        Optional<Students> optionalStudents = studentRepository.findById(id);
        if (optionalStudents.isPresent()){
            Students students = optionalStudents.get();
            students.setRollNo(studentPayload.getRollNo());
            students.setFirstName(studentPayload.getFirstName());
            students.setLastName(studentPayload.getLastName());
            students.setDateOfBirth(studentPayload.getDateOfBirth());
            students.setGender(studentPayload.getGender());
            students.setStatus(studentPayload.getStatus());
            studentRepository.save(students);
        } else {
            throw new IllegalArgumentException("student with id " + id + "not found");
        }
    }

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }


    public Optional<Students> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
