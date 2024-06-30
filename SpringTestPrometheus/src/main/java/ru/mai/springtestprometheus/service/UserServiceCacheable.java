package ru.mai.springtestprometheus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.mai.springtestprometheus.dto.mapper.UserMapper;
import ru.mai.springtestprometheus.dto.request.UserCreateRequest;
import ru.mai.springtestprometheus.dto.request.UserUpdateRequest;
import ru.mai.springtestprometheus.dto.response.UserResponse;
import ru.mai.springtestprometheus.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceCacheable {

    private final UserRepository userRepository;

    public UserResponse createUser(UserCreateRequest request) {
        return UserMapper.modelToResponse(userRepository.saveAndFlush(UserMapper.createRequestToModel(request)));
    }

    @CachePut("cacheUser")
    public UserResponse updateUser(UserUpdateRequest request) {
        return UserMapper.modelToResponse(userRepository.saveAndFlush(UserMapper.updateRequestToModel(request)));
    }

    @Cacheable("cacheUser")
    public UserResponse getUser(Long id) {
        return UserMapper.modelToResponse(userRepository.findById(id).orElse(null));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::modelToResponse).toList();
    }

    @CacheEvict("cacheUser")
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

}
