package id.my.hendisantika.pastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import id.my.hendisantika.pastreamer.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jpa-streamer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/06/24
 * Time: 18.46
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JPAStreamer jpaStreamer;

    @BeforeAll
    public void setup() {
        Assertions.assertNotNull(jpaStreamer);

        userRepository.save(new User(null, "username-1", LocalDate.of(1981, 01, 01), true));
        userRepository.save(new User(null, "username-2", LocalDate.of(2001, 01, 01), true));
        userRepository.save(new User(null, "username-3", LocalDate.of(2002, 01, 01), true));
        userRepository.save(new User(null, "username-4", LocalDate.of(1984, 01, 01), false));
        userRepository.save(new User(null, "username-5", LocalDate.of(1985, 01, 01), false));
    }
}
