package ttl.larku.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
@ExtendWith(MockitoExtension.class)
public class StudentControllerUnitTest {
    @Mock
    private StudentService studentService;

    @Mock
    private UriCreator uriCreator;

    @InjectMocks
    private StudentController controller;


    List<Student> students = Arrays.asList(
            new Student("Manoj", "282 929 9292", Student.Status.FULL_TIME),
            new Student("Alice", "393 9393 030", Student.Status.HIBERNATING));

    private final int goodStudentId = 1;
    private final int badStudentId = 10000;

    @Test
    public void testAddStudent() throws URISyntaxException {
        Student s = students.get(0);
        Mockito.when(studentService.createStudent(s)).thenReturn(s);

        var fakeURI = new URI("http://localhost:8080/student/0");
        Mockito.when(uriCreator.createURI(0)).thenReturn(fakeURI);

        ResponseEntity<?> result = controller.addStudent(s);

        assertEquals(201, result.getStatusCodeValue());

        Mockito.verify(studentService).createStudent(s);
    }

}
