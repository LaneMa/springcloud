package com.lane.study.ribbonconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient //开启eureka客户端功能
//@EnableCircuitBreaker  //开启断路器功能
@SpringCloudApplication  //该注解等于上面三个相加，意味着标准springcloud包含 服务发现和断路器
public class RibbonConsumer1Application {

	/**
	 * LoadBalanced 负载均衡  默认轮询
	 * restful 调用
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumer1Application.class, args);
	}
}
