package de.fourtyseveneleven.ones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OnesWebapp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplication(OnesWebapp.class).run(args);
    }

}