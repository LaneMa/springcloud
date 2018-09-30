package com.lane.study.feignconsumer1.service.fallback;

import com.lane.study.feignconsumer1.service.FeignService1;
import com.lane.study.metadata.dto.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 继承FallbackFactory实现服务降级，可以捕获到啥异常导致降级服务的
 * 启动的时候会抛出一个RuntimeException来检查是否可用，所以启动的时候看到这个异常不要紧张
 */
@Component
public class FeignService1Fallback implements FallbackFactory<FeignService1> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public FeignService1 create(Throwable e) {

        logger.error("降级服务:", e);

        return new FeignService1() {
            @Override
            public String test() {
                return "哈哈，你个傻逼，出错啦!";
            }

            @Override
            public String test(User user) {
                return "哈哈，你个傻逼，出错啦!";
            }

            @Override
            public String getTest(String name) {
                return "哈哈，你个傻逼，出错啦!";
            }

            @Override
            public String test1(String name) {
                return "哈哈，你个傻逼，出错啦!";
            }
        };
    }
}
