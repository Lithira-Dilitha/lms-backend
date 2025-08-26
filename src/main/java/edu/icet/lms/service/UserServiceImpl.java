package edu.icet.lms.service;

import edu.icet.lms.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int rejisterUser(User user) {
        String sql = "INSERT INTO Users (name,email,password,role) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPassword(),user.getRole());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT id,name,email,role FROM Users WHERE email =?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{email}, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        null, // password (ignored)
                        rs.getString("role")
                )
        );
            return users.stream().findFirst();
    }

    @Override
    public int update(User user) {

        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("User or User ID must not be null");
        }
        String sql = "UPDATE Users SET name = ?,email = ?,password = ? WHERE id =?";
        return jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getPassword(),user.getId());
    }

    @Override
    public List<User> allUsers() {
        String sql = "SELECT * FROM Users";
        return  jdbcTemplate.query(sql,(rs, rowNum) ->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            return user;
        });
    }
}
