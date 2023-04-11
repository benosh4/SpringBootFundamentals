package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.List;

/**
 * @author whynot
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello from StudentController";
    }

    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = studentService.getAllStudents();

        return students;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);

        return student;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);

        return newStudent;
    }


}
