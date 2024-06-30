package ru.mai.springtestprometheus.service;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.springtestprometheus.dto.mapper.UserMapper;
import ru.mai.springtestprometheus.dto.request.UserCreateRequest;
import ru.mai.springtestprometheus.dto.request.UserUpdateRequest;
import ru.mai.springtestprometheus.dto.response.UserResponse;
import ru.mai.springtestprometheus.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserServiceCacheable userServiceCacheable;

    @Timed("create")
    public List<UserResponse> createUser(List<UserCreateRequest> requests) {
        return userRepository.saveAllAndFlush(requests.stream().map(UserMapper::createRequestToModel).toList()).stream().map(UserMapper::modelToResponse).toList();
    }

    @Timed("update")
    public List<UserResponse> updateUser(List<UserUpdateRequest> requests) {
        return userRepository.saveAllAndFlush(requests.stream().map(UserMapper::updateRequestToModel).toList()).stream().map(UserMapper::modelToResponse).toList();
    }

    @Timed("get")
    public List<UserResponse> getUser(List<Long> ids) {
        return userRepository.findAllById(ids).stream().map(UserMapper::modelToResponse).toList();
    }

    @Timed("getAll")
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::modelToResponse).toList();
    }

    @Timed("remove")
    public void removeUser(List<Long> ids) {
        userRepository.deleteAllById(ids);
    }

    @Timed("createCache")
    public List<UserResponse> createUserCache(List<UserCreateRequest> requests) {
        return requests.stream().map(userServiceCacheable::createUser).toList();
    }

    @Timed("updateCache")
    public List<UserResponse> updateUserCache(List<UserUpdateRequest> requests) {
        return requests.stream().map(userServiceCacheable::updateUser).toList();
    }

    @Timed("getCache")
    public List<UserResponse> getUserCache(List<Long> ids) {
        return ids.stream().map(userServiceCacheable::getUser).toList();
    }

    @Timed("getAllCache")
    public List<UserResponse> getAllUsersCache() {
        return userServiceCacheable.getAllUsers();
    }

    @Timed("removeCache")
    public void removeUserCache(List<Long> ids) {
        ids.forEach(userServiceCacheable::removeUser);
    }

}
