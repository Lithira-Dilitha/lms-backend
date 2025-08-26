package edu.icet.lms.controller;

import edu.icet.lms.model.User;
import edu.icet.lms.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final  UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.rejisterUser(user));
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.allUsers();
    }
    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
    @PutMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user));
    }
}
