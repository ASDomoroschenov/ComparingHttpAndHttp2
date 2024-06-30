package ru.mai.requestsender;

import ru.mai.requestsender.dto.UserCreateRequest;
import ru.mai.requestsender.dto.UserUpdateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataGenerator {

    private TestDataGenerator() {}

    private static final Random random = new Random();

    public static List<UserCreateRequest> generateCreateRequests(int count) {
        List<UserCreateRequest> requests = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            UserCreateRequest request = UserCreateRequest.builder()
                    .firstname("Firstname" + i)
                    .lastname("Lastname" + i)
                    .weight(random.nextInt(100))
                    .height(random.nextInt(200))
                    .build();
            requests.add(request);
        }

        return requests;
    }

    public static List<UserUpdateRequest> generateUpdateRequests(List<Long> ids) {
        List<UserUpdateRequest> requests = new ArrayList<>();

        for (Long id : ids) {
            UserUpdateRequest request = UserUpdateRequest.builder()
                    .id(id)
                    .firstname("UpdatedFirstname" + id)
                    .lastname("UpdatedLastname" + id)
                    .weight(random.nextInt(100))
                    .height(random.nextInt(200))
                    .build();
            requests.add(request);
        }

        return requests;
    }

}