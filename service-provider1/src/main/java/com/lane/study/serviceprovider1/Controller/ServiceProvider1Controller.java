package com.lane.study.serviceprovider1.Controller;

import com.lane.study.metadata.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/provider")
public class ServiceProvider1Controller {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "this is service provider1";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@RequestBody User user) {
        return user.toString();
    }
}
