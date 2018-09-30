package com.lane.study.serviceprovider2.rest;

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
    public void delete() {
        System.out.println("this is restful delete");
    }

    @PutMapping
    public void update() {
        System.out.println("this is restful put");
    }
}
