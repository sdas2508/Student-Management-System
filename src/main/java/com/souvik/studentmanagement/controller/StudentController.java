package com.souvik.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.souvik.studentmanagement.entity.Student;
import com.souvik.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Manage students (CRUD)
    @GetMapping
    public String manageStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("student", new Student());
        return "Students"; // full CRUD page
    }

    // View all students (read-only)
    @GetMapping("/view")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "ViewStudent"; // read-only table
    }

    // Add new student
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    // Update student
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Integer id, @ModelAttribute Student student) {
        student.setStudentId(id);
        studentRepository.save(student);
        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
