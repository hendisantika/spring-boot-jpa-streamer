package id.my.hendisantika.pastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
