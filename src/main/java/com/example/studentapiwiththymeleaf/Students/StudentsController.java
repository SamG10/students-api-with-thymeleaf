package com.example.studentapiwiththymeleaf.Students;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller()
public class StudentsController {
    private final StudentsService studentsService;
    private final StudentsRestController studentsRestController;

    public StudentsController(StudentsService studentsService , StudentsRestController studentsRestController) throws Exception {
        this.studentsService = studentsService;
        this.studentsRestController = studentsRestController;
    }

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("/add-student")
    public String addStudentPage() {
        return "formulaire";
    }

    @PostMapping("/submitForm")
    public String submit(@ModelAttribute("studentSubmit") Student student) {
        System.out.println(student);
        studentsService.create(student);
        return "redirect:/add-student";
    }

    @GetMapping("/search-students")
    public String getAllStudent(Model model) {
        List<Student> students = studentsRestController.findAll();
        System.out.println(students);
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("deleteStudent")
    public String deleteSubmit(@ModelAttribute("studentDelete") Student student) {
        System.out.println("student : " + student.getId());
        studentsService.delete(student.getId());
        return "redirect:/search-students";
    }

    @GetMapping("/student-details/{id}")
    public String getStudentDetails(@PathVariable() String id, Model model) {
        System.out.println("iddddd : " + id);
        Student student = studentsService.findOne(id);
        model.addAttribute("student", student);
        return "student-details";
    }


}
