package id.my.hendisantika.pastreamer.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import id.my.hendisantika.pastreamer.entity.User;
import id.my.hendisantika.pastreamer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return jpaStreamer.stream(User.class).collect(Collectors.toList());
    }
}
