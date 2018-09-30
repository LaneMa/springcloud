package com.lane.study.feignconsumer1.service;

import com.lane.study.feignconsumer1.service.fallback.FeignService1Fallback;
import com.lane.study.metadata.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SERVCICE-PROVIDER", fallbackFactory = FeignService1Fallback.class)
public interface FeignService1 {

    /**
     * 说明SpringMVC支持restAPI调用
     * @return
     */
    @RequestMapping(value = "service/provider/test", consumes = "application/json")
    String test();

    /**
     * 对象必须post请求
     * @param user
     * @return
     */
    @PostMapping(value = "service/provider/test", consumes = "application/json")
    String test(User user);

    /**
     * 注解@PathVariable中value必填，否则IllegalStateException
     * @param name
     * @return
     */
    @GetMapping(value = "service/provider/{name}", consumes = "application/json")
    String getTest(@PathVariable("name") String name);

    /**
     * 注解@RequestParam 必填
     * @param name
     * @return
     */
    @GetMapping(value = "service/provider/test1", consumes = "application/json")
    String test1(@RequestParam("name") String name);
}
