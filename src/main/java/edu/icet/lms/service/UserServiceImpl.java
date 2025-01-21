package edu.icet.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.lms.entity.UserEntity;
import edu.icet.lms.model.User;
import edu.icet.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    final UserRepository userRepository;
    final ObjectMapper mapper;

    @Override
    public User rejisterUser(User user){
        return mapper.convertValue(userRepository.save
                (mapper.convertValue(user, UserEntity.class)),
                User.class);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
