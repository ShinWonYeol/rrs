package com.juju.review.model;
// 맛집 정보를 위한 클래스
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Builder
// pk를 자동으로 만들어주고 해당 클래스의 필드에 접근할 때 빌드를 통해 접근할 수 있게 도와줌
@AllArgsConstructor
// AllArgsConstructor 는 모든 필드 값을 파라미터로 받는 생성자를 생성 this.필드1 = 필드1
@NoArgsConstructor(force = true)
// NoArgsConstructor 는 필드가 없는 생성자 final 같은 필드에 사용하면 에러가 발생, force 옵션에 true를 주면 0/false/null 로 초기화
@Table(name ="restaurant")
@Entity
// JPA가 이 클래스를 DB에 매핑하겠다
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private String name;
    private String addresses;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void changeNameANdAddresses(String name, String addresses){
        this.name = name;
        this.addresses = addresses;
        this.updatedAt = ZonedDateTime.now();
    }
}
