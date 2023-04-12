package ttl.larku.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.Arrays;
import java.util.List;

/**
 * @author whynot
 */
@ExtendWith(MockitoExtension.class)
public class StudentControllerUnitTest {
    @InjectMocks
    private StudentController controller;

    @Mock
    private StudentService studentService;

    List<Student> students = Arrays.asList(
            new Student("Manoj", "282 929 9292", Student.Status.FULL_TIME),
            new Student("Alice", "393 9393 030", Student.Status.HIBERNATING));

    private final int goodStudentId = 1;
    private final int badStudentId = 10000;

    @Test
    public void testCreateStudent() {
        Mockito.when(studentService.createStudent(students.get(0))).thenReturn(students.get(0));
    }
}
