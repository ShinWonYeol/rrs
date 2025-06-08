package com.juju.review.model;
// DB 테이블과 매핑되는 클래스, 테이블의 구조를 정의
// H2는 자바에서 제공하는 데이터베이스
// Jpa는 자바 orm 기반으로 동작되는데 orm은 객체와 관계형 데이터베이스를 매핑해주는 기술이다.
// jpa는 자바 애클리케이션과 jdbc 사이에 동작하여 개발자 대신 Jdbc api를 통해 sql문을 db에 전달한다.
// resource에서 apllication 설정 부분에 있는 부분에 의해 h2-console이라는 경로로 접속하여 db 설정 가능

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "test")
// test 라는 이름으로  테이블 생성
@Entity
// Entity 어노테이션은 Entity가 붙은 클래스를 Jpa가 관리하도록 명시함
public class TestEntity {
    // ID는 데이터베이스 테이블의 기본키와 객체의 필드를 매핑시켜준다
    // ID뒤 GeneratedValue를 사용하면 데이터베이스가 생성해주는 값을 사용
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 전력 속성 중 Identity 전략은 기본 키 생성을 DB에 위임한다
    private Long id;
    private String name;
    private Integer age;

    public TestEntity(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public TestEntity(){

    };

    // 압데이트를 위한 구문
    public void changeNameAndAge(String name, Integer age){
        this.name = name;
        this.age = age;
    }


}
