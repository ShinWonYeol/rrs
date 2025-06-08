package com.juju.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class _02_TestRequestAPI {

    // Request Parameter 방식
    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    )
    {
        return "Hello, Request Param, I am " + name + "," + age;
    }

    // Path Variable 방식
    @GetMapping("/test/path/{name}/{age}")
    private String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ){
        return "Hello, Path Variable, I am " + name + "," + age;
    }

    // Request Body 방식
    public static class TestRequestBody{
        String name;
        Integer age;

        // 생성자를 만들지 않으면 name과 age는 모두 NULL이 됨
        public TestRequestBody(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    @PostMapping("/test/body")
    private String reqeustBody(
            @RequestBody TestRequestBody request
    ){
        return "Hellow, Reauest Body, I am " + request.name +", " + request.age;
    }

}
