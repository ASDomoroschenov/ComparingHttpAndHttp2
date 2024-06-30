package ru.mai.springtestprometheus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mai.springtestprometheus.dto.request.UserCreateRequest;
import ru.mai.springtestprometheus.dto.request.UserUpdateRequest;
import ru.mai.springtestprometheus.dto.response.UserResponse;
import ru.mai.springtestprometheus.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public List<UserResponse> createUsers(@RequestBody List<UserCreateRequest> requests) {
        return userService.createUser(requests);
    }

    @PutMapping("/update")
    public List<UserResponse> updateUsers(@RequestBody List<UserUpdateRequest> requests) {
        return userService.updateUser(requests);
    }

    @GetMapping("/retrieve-all")
    public List<UserResponse> retrieveAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/retrieve-all-by-ids")
    public List<UserResponse> retrieveAllByIds(@RequestParam("ids") List<Long> ids) {
        return userService.getUser(ids);
    }

    @DeleteMapping("/remove")
    public void removeUsers(@RequestParam("ids") List<Long> ids) {
        userService.removeUser(ids);
    }

}
