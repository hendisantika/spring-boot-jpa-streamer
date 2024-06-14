package id.my.hendisantika.pastreamer.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import id.my.hendisantika.pastreamer.entity.User;
import id.my.hendisantika.pastreamer.entity.User$;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

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

    @Test
    void testGetAllUsers_With_Status_Inactive() {
        List<User> inactiveUsers = jpaStreamer.stream(User.class)
                .filter(u -> !u.getActive())
                .toList();

        Assertions.assertEquals(2, inactiveUsers.size());
    }

    @Test
    void testGetAllUsers_With_Dob_Null() {
        List<User> usersWithoutDateOfBirth = jpaStreamer.stream(User.class)
                .filter(User$.dateOfBirth.isNull())
                .toList();

        Assertions.assertEquals(0, usersWithoutDateOfBirth.size());
    }

    @Test
    void testGetAllUsers_With_Dob_NotNull() {
        List<User> usersWithDateOfBirth = jpaStreamer.stream(User.class)
                .filter(User$.dateOfBirth.isNotNull())
                .toList();

        Assertions.assertEquals(5, usersWithDateOfBirth.size());
    }

    @Test
    void testGetAllUsers_Born_After_2000() {
        List<User> users = jpaStreamer.stream(User.class)
                .filter(User$.dateOfBirth.greaterThan(LocalDate.of(2000, 1, 1)))
                .toList();

        Assertions.assertEquals(2, users.size());
    }

    @Test
    void testGetAllUsers_Page_Size_2() {
        List<User> users = jpaStreamer.stream(User.class)
                .skip(2)
                .limit(2)
                .toList();

        Assertions.assertEquals(2, users.size());
    }
}
