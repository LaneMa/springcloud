package com.lane.study.ribbonconsumer1.service.impl;

import com.lane.study.ribbonconsumer1.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@Service
public class HystrixServiceImpl implements HystrixService {

    @Resource
    RestTemplate restTemplate;

    /**
     * 应用下线后，并没有立即从注册中心剔除实例，这时候访问会报错，随后调用helloFallback方法返回结果
     * 在最大等待时间60s（注册中心剔除时间+客户端服务列表刷新时间）后，注册中心剔除实例，客户端刷新服务列表后，下线的服务将不再调用
     *
     * 如应用不是正常下线，注册中心开启保护模式，只要调用不正常的服务就会返回helloFallback这个方法
     *
     * ignoreExceptions  ArrayIndexOutOfBoundsException此异常将不会进入降级处理，直接抛出
     * fallbackMethod  同一个类，意味着降级处理方法前面的修饰符并不重要，无论是private还是public等等；入参相同，否则找不到，意味着可以进行重载
     * @see com.netflix.hystrix.HystrixCommandProperties commandProperties配置参数，name在构造函数方法中
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback",
            ignoreExceptions = {ArrayIndexOutOfBoundsException.class},
            commandProperties = {
                @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000") //线程运行超时时间，也就是说如果test方法运行时间超过5s Hystrix会报超时异常，网上说是链接服务超时时间，真是扯鸡巴蛋
            }
    )
    @Override
    public String test() {
        return restTemplate.getForEntity("http://SERVCICE-PROVIDER/service/provider/test", String.class) .getBody();
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    @Override
    public String test(String var) {
        System.out.println(var);
        if ("NullPointerException".equals(var)) {
            throw new NullPointerException();
        } else if ("IndexOutOfBoundsException".equals(var)) {
            throw new IndexOutOfBoundsException();
        }
        return restTemplate.getForEntity("http://SERVCICE-PROVIDER/service/provider/test", String.class) .getBody();
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    @Override
    public Future<String> asyncTest(String var) {//特么的返回结果一定要是Future，也就是说容灾最好是针对请求服务
        return new AsyncResult<String>() {
            @Override
            public String invoke() {//服务端打个断点
                System.out.println("能不能行");
                String r = restTemplate.getForEntity("http://SERVCICE-PROVIDER/service/provider/test", String.class) .getBody();
                System.out.println("result:" + r);
                return r;
            }
        };
    }

    String helloFallback(Throwable e) { //降级处理方法前面的修饰符并不重要
        System.out.println("========");
        if (e instanceof NullPointerException) {
            return "NullPointerException";
        }
        return "出错啦";
    }

    @HystrixCommand(fallbackMethod="lastFallback",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.strategy", value = "SEMAPHORE") //降级处理方法中，默认是信号量代替线程池
            })
    String helloFallback(String var, Throwable e) {//降级处理，若降级过程中还有可能出错，继续降级，直到最后有稳定的输出
        System.out.println("========");
        if (e instanceof NullPointerException) {
            return "NullPointerException";
        } else if ("IndexOutOfBoundsException".equals(var)) {
            throw new IndexOutOfBoundsException();
        }
        return "出错啦";
    }

    String lastFallback(String var, Throwable e) {
        return "FUCK YOU";
    }

}
