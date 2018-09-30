package com.lane.study.feignconsumer1.service.fallback;

import com.lane.study.feignconsumer1.service.FeignService;
import com.lane.study.metadata.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 重写的方法就是降级服务，比如test()方法，当FeignService.test()抛出异常后，就会执行，实现服务降级
 */
@Component
public class FeignServiceFallback implements FeignService {

    @Override
    public String test() {
        return null;
    }

    @Override
    public String test(@RequestBody User user) {
        return "哈哈，你个傻逼，出错啦!";
    }

    @Override
    public String getTest(String name) {
        return null;
    }

    @Override
    public String test1(String name) {
        return "哈哈，你个傻逼，出错啦!";
    }
}
