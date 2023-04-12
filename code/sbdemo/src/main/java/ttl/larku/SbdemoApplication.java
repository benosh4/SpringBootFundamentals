package ttl.larku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.List;

@SpringBootApplication
public class SbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbdemoApplication.class, args);
    }

    @Bean
//	TODO - why not working??
	@Order(1)
    public CommandLineRunner runner3() {
		return (String ...args) -> System.out.println("Hello from Runner3");
    }

}

@Component
@Order(2)
class MyRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from otherRunner");
    }
}

@Component
@Order(3)
class MyRunner implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyRunner called");
        List<Student> students = studentService.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
