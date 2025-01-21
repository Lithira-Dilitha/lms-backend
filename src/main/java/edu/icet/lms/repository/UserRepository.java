package edu.icet.lms.repository;

import edu.icet.lms.entity.UserEntity;
import edu.icet.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<User> findByEmail(String email);
}
