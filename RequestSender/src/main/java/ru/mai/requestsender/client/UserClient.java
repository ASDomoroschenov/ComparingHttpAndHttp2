package ru.mai.requestsender.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.mai.requestsender.dto.UserCreateRequest;
import ru.mai.requestsender.dto.UserResponse;
import ru.mai.requestsender.dto.UserUpdateRequest;

import java.util.List;

@FeignClient(name = "userClient", url = "http://localhost:8080/user"/*, configuration = Http2ClientFeignConfiguration.class*/)
public interface UserClient {

    @PostMapping("/create")
    List<UserResponse> createUsers(@RequestBody List<UserCreateRequest> requests);

    @PutMapping("/update")
    List<UserResponse> updateUsers(@RequestBody List<UserUpdateRequest> requests);

    @GetMapping("/retrieve-all")
    List<UserResponse> retrieveAllUsers();

    @GetMapping("/retrieve-all-by-ids")
    List<UserResponse> retrieveAllByIds(@RequestParam("ids") List<Long> ids);

    @DeleteMapping("/remove")
    void removeUsers(@RequestParam("ids") List<Long> ids);

}
