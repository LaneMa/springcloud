package com.lane.study.feignconsumer1;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringCloudApplication
public class FeignConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumer1Application.class, args);
	}

}
