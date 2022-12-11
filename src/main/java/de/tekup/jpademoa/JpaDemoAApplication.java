package de.tekup.jpademoa;

import de.tekup.jpademoa.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class JpaDemoAApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoAApplication.class, args);
    }

}
