package edu.icet.lms.service;

import edu.icet.lms.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    int rejisterUser(User user);
    Optional<User> findByEmail(String email);
    int update(User user);
    List<User> allUsers();
}
