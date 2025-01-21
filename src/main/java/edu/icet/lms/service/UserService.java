package edu.icet.lms.service;

import edu.icet.lms.model.User;

public interface UserService {
    User rejisterUser(User user);
    User findByEmail(String email);
    User update(User user);
}
