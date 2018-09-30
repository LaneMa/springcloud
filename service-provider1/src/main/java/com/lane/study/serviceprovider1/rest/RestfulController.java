package com.lane.study.serviceprovider1.rest;
/**
 * restful api 最小粒度定义比较模糊，在复杂的业务系统中开发 并不是很友好
 */
import org.springframework.web.bind.annotation.*;

@RequestMapping("/restful")
@RestController
public class RestfulController {

    @GetMapping
    public String read() {
        return "this is restful get";
    }

    @PostMapping
    public String save() {
        return "this is restful post";
    }

    @DeleteMapping
    public String delete() {
        return "this is restful delete";
    }

    @PutMapping
    public String update() {
        return "this is restful put";
    }
}
