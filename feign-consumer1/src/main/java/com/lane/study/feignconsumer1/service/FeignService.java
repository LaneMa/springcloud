package com.lane.study.feignconsumer1.service;

import com.lane.study.feignconsumer1.service.fallback.FeignServiceFallback;
import com.lane.study.metadata.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * name为服务名，这是集成了eureka。如果不集成eureka，可以用url执行具体的路径或者域名
 */
@FeignClient(name = "SERVCICE-PROVIDER", fallback = FeignServiceFallback.class)
public interface FeignService {

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
     * @PathVariable value必填，否则IllegalStateException
     * @param name
     * @return
     */
    @GetMapping(value = "service/provider/{name}", consumes = "application/json")
    String getTest(@PathVariable("name") String name);

    @GetMapping(value = "service/provider/test1", consumes = "application/json")
    String test1(String name);
}
