package com.juju.review.api;

import com.juju.review.model.TestEntity;
import com.juju.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class _06_TestQueryApi {

    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJPA(
            @RequestParam("name") String name
    ){
      return testService.findAllByNameByJPA(name);
    }
    // 아래는 단일 검색
//    public List<TestEntity> queryJPA(){
//        return testService.findAllByNameByJPA("juju");
//    }

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> queryQuerydsl(
            @RequestParam("name") String name
    ){
        return testService.findAllByNameByQuerydsl(name);
    }
    // 아래는 단일 검색
//    public List<TestEntity> queryQuerydsl(){
//        return testService.findAllByNameByQuerydsl("juju");
//    }
}
