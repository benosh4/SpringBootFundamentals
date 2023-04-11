package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdemoApplication.class, args);
	}
}

@Component
class MyRunner implements CommandLineRunner
{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyRunner called");
	}
}