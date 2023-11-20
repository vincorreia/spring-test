package com.vincorreia.springtest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path= "/all")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody Student student) {
        return this.studentService.registerStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public Student updateStudent(
            @PathVariable("id") long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return this.studentService.updateStudent(id, name, email);
    }
}
