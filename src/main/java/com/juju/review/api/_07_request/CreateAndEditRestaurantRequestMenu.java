package com.juju.review.api._07_request;
// 맛집의 메뉴를 만들고 수정하기 위한 클래스

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequestMenu {
    private final String name;
    private final Integer price;
}
