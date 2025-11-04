package com.souvik.studentmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "studentmanagement")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String studentName;
    private String address;
    private String phoneNo;
    private String email;
    private Integer cls;

    public Student() {}

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getCls() { return cls; }
    public void setCls(Integer cls) { this.cls = cls; }
}
