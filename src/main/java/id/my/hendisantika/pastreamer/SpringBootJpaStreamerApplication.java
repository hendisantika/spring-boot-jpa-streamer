package id.my.hendisantika.pastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.speedment.jpastreamer"})
public class SpringBootJpaStreamerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaStreamerApplication.class, args);
    }

}
