package com.juju.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _03_TestResponseAPI {

    @GetMapping("/test/response/string")
    public String stringRestponse(){
        return "This is String";
    }


    // Header 부분에 Json 형태로 보내기 위한 클래스 생성
    public static class TestResoponseBody{
        String name;

        Integer age;

        public TestResoponseBody(String name, Integer age) {
            this.age = age;
            this.name = name;
        }
        // getter 는 private 값을 외부로 꺼내는 메서드로 내부 변수에 저장된 값을 외부로 리턴한다.
        // 매개변수가 없으며 리턴값 하나만 존재한다 메서드명은 주로 get변수명() 형태로 지정한다.
        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    // 클래스 없이 아래와 같이 하면 헤더의 값이 text임
//    @GetMapping("/test/response/json")
//    public String jsonResponse(){
//        return "{\"name\" : \"This is Json\"}";
//    }

    @GetMapping("/test/response/json")
    public TestResoponseBody jsonResponse(){
        return new TestResoponseBody("wyshin", 28);
    }

}
