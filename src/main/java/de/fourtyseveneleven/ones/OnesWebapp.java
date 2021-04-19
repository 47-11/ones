package de.fourtyseveneleven.ones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "de.fourtyseveneleven.ones.repository")
public class OnesWebapp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplication(OnesWebapp.class).run(args);
    }

}