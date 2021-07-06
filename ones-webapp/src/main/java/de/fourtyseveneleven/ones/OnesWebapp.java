package de.fourtyseveneleven.ones;

import de.fourtyseveneleven.ones.settings.OnesSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {OnesWebapp.class})
@EnableConfigurationProperties({OnesSettings.class})
public class OnesWebapp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringApplication(OnesWebapp.class).run(args);
    }

}