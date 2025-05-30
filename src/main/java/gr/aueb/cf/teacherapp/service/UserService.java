package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.model.User;
import gr.aueb.cf.teacherapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));   // encrypt password
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
