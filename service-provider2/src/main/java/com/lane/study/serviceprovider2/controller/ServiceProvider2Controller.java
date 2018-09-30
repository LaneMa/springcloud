package com.lane.study.serviceprovider2.controller;

import com.lane.study.metadata.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/provider")
public class ServiceProvider2Controller {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "this is service provider2";
    }

    /**
     * 传递对象请使用post方式,并且接收端使用@RequestBody注解
     * @param user
     * @return
     */
    @PostMapping(value = "/test")
    public String test(@RequestBody User user) {
        return user.toString();
    }

    @GetMapping(value = "/{name}")
    public String getTest(@PathVariable("name") String name){
        return name;
    }

    @GetMapping(value = "/test1")
    public String test1(@RequestParam("name") String name){
        return name;
    }

}
