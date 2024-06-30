package ru.mai.requestsender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mai.requestsender.client.UserClient;
import ru.mai.requestsender.dto.UserCreateRequest;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RequestSender {

    private static final Random random = new Random();
    private final UserClient userClient;

    public void testCreate() {
        List<UserCreateRequest> requests = TestDataGenerator.generateCreateRequests(10000);
        userClient.createUsers(requests);
    }

    public void testGet() {
        List<Long> ids = random.longs(100, 1, 10000).boxed().toList();
        userClient.retrieveAllByIds(ids);
    }

}
