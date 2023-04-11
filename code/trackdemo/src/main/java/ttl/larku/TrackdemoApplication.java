//package com.example.demo;
package ttl.larku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Track;
import ttl.larku.service.TrackService;

import java.util.List;

//@SpringBootApplication(scanBasePackages = {"ttl.larku.jconfig", "com.example.demo"})
@SpringBootApplication
public class TrackdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackdemoApplication.class, args);
    }
}

@Component
class MyRunner implements CommandLineRunner {

    @Autowired
    private TrackService ts;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyRunner called");

        List<Track> tracks = ts.getAllTracks();
        tracks.forEach(System.out::println);
    }
}
