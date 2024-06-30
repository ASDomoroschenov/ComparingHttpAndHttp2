package ru.mai.requestsender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@Slf4j
@EnableFeignClients
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class RequestSenderApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(RequestSenderApplication.class, args);

        RequestSender sender = context.getBean(RequestSender.class);

        log.info("Start application");
        for (int i = 0; i < 10000; i++) {
            sender.testGet();
        }
        log.info("End application");
    }

}
