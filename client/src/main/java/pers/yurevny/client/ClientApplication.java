package pers.yurevny.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.event.EventListener;


@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties

public class ClientApplication {

    @Value("${value}")
    private String value;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @EventListener
    public void printHello(ApplicationStartedEvent event) {
        System.out.println(value);
    }
}
