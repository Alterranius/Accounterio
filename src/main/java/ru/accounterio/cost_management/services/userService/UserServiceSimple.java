package ru.accounterio.cost_management.services.userService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import ru.accounterio.cost_management.domains.User;
import ru.accounterio.cost_management.interfaces.user.UserService;
import ru.accounterio.cost_management.repositories.postgres.UserRepository;

import java.util.Optional;

@Service
@Log4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserServiceSimple implements UserService {
    UserRepository userRepository;

    @Override
    public Long addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public boolean login(User user) {
        return false;
    }



    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresent(userRepository::delete);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }
}
