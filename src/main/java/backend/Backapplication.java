package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableCaching(proxyTargetClass = true)
public class Backapplication {

    public static void main(String[] args) {
        SpringApplication.run(Backapplication.class, args);
    }

}