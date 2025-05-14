package br.com.fiap.coleta.controller;


import br.com.fiap.coleta.dto.UserCreateDTO;
import br.com.fiap.coleta.dto.UserExhibitionDTO;
import br.com.fiap.coleta.model.User;
import br.com.fiap.coleta.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coleta/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserExhibitionDTO saveUser(@RequestBody @Valid UserCreateDTO user) {
        return userService.save(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserExhibitionDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserExhibitionDTO> findUserById (@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));

    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/update/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserExhibitionDTO> updateUser(
            @PathVariable Long userId,
            @RequestBody @Valid UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userService.updateUser(userId, userCreateDTO));
    }



}
