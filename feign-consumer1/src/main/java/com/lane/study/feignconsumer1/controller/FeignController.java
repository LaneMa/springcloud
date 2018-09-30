package com.lane.study.feignconsumer1.controller;

/**
 * feign是ribbon和hystrix的结合，restfulApi并不友好，
 */
import com.lane.study.feignconsumer1.service.FeignService;
import com.lane.study.feignconsumer1.service.FeignService1;
import com.lane.study.metadata.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    FeignService feignService;

    @Resource
    FeignService1 feignService1;

    @RequestMapping("/test")
    public String test(){
        return feignService.test();
    }

    @RequestMapping("/test1")
    public String test1(){
        User user = new User();
        user.setAge(100);
        user.setJob("程序员");
        user.setMark("程序员的悲剧生活");
        user.setName("John");
        user.setSex("female");
        return feignService.test(user);
    }

    @GetMapping("/getTest/{name}")
    public String getTest(@PathVariable("name") String name){
        return feignService.getTest(name);
    }


    @GetMapping("/test2")
    public String test2(String name){
        return feignService1.test1(name);
    }
}
