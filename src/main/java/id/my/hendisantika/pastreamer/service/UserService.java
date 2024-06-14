package id.my.hendisantika.pastreamer.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import id.my.hendisantika.pastreamer.entity.User;
import id.my.hendisantika.pastreamer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jpa-streamer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/06/24
 * Time: 18.42
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JPAStreamer jpaStreamer;

    public Iterable<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }
}
