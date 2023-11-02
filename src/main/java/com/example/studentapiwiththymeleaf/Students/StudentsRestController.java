package com.example.studentapiwiththymeleaf.Students;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("students")
public class StudentsRestController {
    private final StudentsService studentsService;

    public StudentsRestController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping()
    public Student create(@RequestBody() Student student) {
        System.out.println("ok");
        return studentsService.create(student);
    }

    @GetMapping()
    public List<Student> findAll() {
        return studentsService.findAll();
    }

    @GetMapping("/{id}")
    public Student findOne(@PathVariable() String id) {
        return studentsService.findOne(id);
    };

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() String id) {
        studentsService.delete(id);
    }

    @PatchMapping("/{id}")
    public Student update(@PathVariable() String id, @RequestBody() Student student) throws Exception {
        return studentsService.update(id, student);
    }
}
