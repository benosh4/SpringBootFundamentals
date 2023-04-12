package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.net.URI;
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
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if(student == null) {
            return ResponseEntity.status(404).body("No student with id: " + id);
        }

        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);

        URI newResource = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newStudent.getId())
                .toUri();

        return ResponseEntity.created(newResource).build(); //.body(newStudent);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
       boolean b = studentService.updateStudent(student);
       if(b) {
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.badRequest().body("Could Not update student with id: " + student.getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        boolean b = studentService.deleteStudent(id);
        if(b) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Could Not delete student with id: " + id);
    }


}
