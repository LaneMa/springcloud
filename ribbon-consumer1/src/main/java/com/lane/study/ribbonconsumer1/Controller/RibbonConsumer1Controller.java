package com.lane.study.ribbonconsumer1.Controller;

import com.lane.study.ribbonconsumer1.service.HystrixService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ribbon/consumer1")
public class RibbonConsumer1Controller {

    @Resource
    private HystrixService hystrixService;

    @RequestMapping("/test")
    public String test() {
        return hystrixService.test();

//        String getStr = restTemplate.getForEntity("http://SERVCICE-PROVIDER/restful", String.class).getBody();
//        String postStr = restTemplate.postForEntity("http://SERVCICE-PROVIDER/restful",null, String.class).getBody();
//
//        System.out.println("rest get :" + getStr);
//        System.out.println("rest post :" + postStr);
//
//        return restTemplate.getForEntity("http://SERVCICE-PROVIDER/service/provider/test",String.class).getBody();
    }

    @RequestMapping("/test1")
    public String test1(String var) {
        return hystrixService.test(var);
    }

    @RequestMapping("/async")
    public String async(String var) {
        hystrixService.asyncTest(var);
        return "SUCCESS";
    }

}
