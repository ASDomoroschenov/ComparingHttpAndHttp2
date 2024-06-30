package ru.mai.springtestprometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.HttpClient;

@SpringBootApplication
public class SpringTestPrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestPrometheusApplication.class, args);
    }

}
