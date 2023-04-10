package ttl.larku.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

import java.util.List;

/**
 * @author whynot
 */
public class SpringDemo {

    public static void main(String[] args) {
        SpringDemo sd = new SpringDemo();
        //sd.go();
        sd.goCourse();
    }

    public void go() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        StudentService service = context.getBean("studentService", StudentService.class);

        StudentService service2 = context.getBean("studentService", StudentService.class);

        List<Student> students = service.getAllStudents();
        System.out.println("students:");
        students.forEach(System.out::println);
    }

    public void goCourse() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        CourseService service = context.getBean("courseService", CourseService.class);

        List<Course> courses = service.getAllCourses();
        System.out.println("courses:");
        courses.forEach(System.out::println);
    }
}
