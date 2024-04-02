package com.register.demo.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentPayload {
private Long id;
private String rollNo;
private String firstName;
private String lastName;
private Date dateOfBirth;
private String gender;
private Boolean status;
}
