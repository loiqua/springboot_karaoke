package com.example.karaokeprog2spring.controller;

import com.example.karaokeprog2spring.model.users;
import com.example.karaokeprog2spring.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/insert")
    public users insertUser(@RequestBody users user) {
        return usersService.insert(user);
    }

    @GetMapping("/{id}")
    public List<users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return "The user with id = " + id + " is deleted";
    }

    @PutMapping("/update")
    public users updateUser(@RequestBody users toUpdate) {
        return usersService.updateUser(toUpdate);
    }
}
