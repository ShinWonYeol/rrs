package com.juju.review.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _04_TestLombokAPI {
    /* Lombok은 Java 라이브러리로 반복되는 메소드를 어노테이션을 통해 작성해주는 라이브러리
    모델 클래스나 객체와 같은 도메인 클래스등에 여러 속성들이 존재하고 이들의 속성들에 대하여
    생성자, Setter, Getter 등을 매번 작성해줘야 하는데 Lombok을 사용하면
    어노테이션을 이용하는것만으로 자동으로 생성자, Getter, Setter 등을 작성해줘 편의성을 제공한다.
    */


    // Json 형태를 전달하기 위한 클래스 생성
    @Getter
    // getter를 어노테이션 만으로 자동 생성
    @AllArgsConstructor
    // 생성자를 어노테이션 만으로 자동 생성
    public static class TestLombokResponse{
        String name;
        Integer age;
    }

    @GetMapping("/test/lombok")
    public TestLombokResponse testLombok(){
        return new TestLombokResponse("wyshin", 28);

    }
}
