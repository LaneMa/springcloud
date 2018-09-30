//package com.lane.study.feignconsumer1.configuration;
//
//import feign.Feign;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
///**
// * 设置熔断器不可用
// * 这里返回的是Feign客服端配置，而不是HystrixFeign，所以熔断器不能用了
// * 这个是全局设置不能用，所以我注释了这个
// */
//@Configuration
//public class DisableHystrixConfig {
//
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder disableHystrix() {
//        return Feign.builder();
//    }
//}
