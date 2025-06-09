package com.juju.review.api._07_request;
// 맛집을 생성하고 수정하는 클래스
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
public class CreateAndEditRestaurantRequest {
    private final String name;
    private final String addresses;
    private final List<CreateAndEditRestaurantRequestMenu> menus;
}
