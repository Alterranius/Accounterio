package ru.accounterio.cost_management.interfaces.user;

import ru.accounterio.cost_management.domains.User;

import java.util.Optional;

public interface UserService {
    Long addUser(User user) throws UserServiceException;
    boolean login(User user) throws UserServiceException;
    void deleteUser(Long userId) throws UserServiceException;
    Optional<User> getUser(Long userId);
}
