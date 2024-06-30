package ru.mai.springtestprometheus.dto.mapper;

import ru.mai.springtestprometheus.dto.request.UserCreateRequest;
import ru.mai.springtestprometheus.dto.request.UserUpdateRequest;
import ru.mai.springtestprometheus.dto.response.UserResponse;
import ru.mai.springtestprometheus.model.User;

public class UserMapper {

    private UserMapper() {}

    public static User createRequestToModel(UserCreateRequest request) {
        return request != null ?
                User.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .weight(request.getWeight())
                        .height(request.getHeight())
                        .build() :
                null;
    }

    public static User updateRequestToModel(UserUpdateRequest request) {
        return request != null ?
                User.builder()
                        .id(request.getId())
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .weight(request.getWeight())
                        .height(request.getHeight())
                        .build() :
                null;
    }

    public static UserResponse modelToResponse(User model) {
        return model != null ?
                UserResponse.builder()
                        .id(model.getId())
                        .firstname(model.getFirstname())
                        .lastname(model.getLastname())
                        .weight(model.getWeight())
                        .height(model.getHeight())
                        .build() :
                null;
    }

}
