package com.juju.review.api;

import com.juju.review.api._07_request.CreateAndEditRestaurantRequest;
import com.juju.review.model.RestaurantEntity;
import com.juju.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class _07_RestaurantApi {

    private final RestaurantService restaurantService;

    // 맛집 리스트 조회
    @GetMapping("/restaurants")
    public String getRestaurants(){
        return "This is getRestaurants";
    }

        //restaurantId 로 추후 변
        // 맛집에 대한 정보 받아오기
    @GetMapping("/restaurant/{id}")
    public String getRestaurant(
            @PathVariable Long id
    ){
        return "This is getRestaurants, " + id;
    }

    // 맛집 생성하기
    @PostMapping("/restaurant")
    //public String createRestaurant(
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
        // 사용자 JSON 데이터를 CreateAndEditRestaurantRequest 객체 형태로 reateRestaurant의 createRestaurant 메서드 인자값으로 전달
        // 이렇게 사용자가 전달해준 JSON 같은 값을 객체로 매핑하기 위한 중간다리 역할인 객체를 DTO fkrh gksek
            restaurantService.createRestaurant(request);
        // Service 부분에서 RestaurantEntity 부분을 수정하고 나서
//        return "This is createRestaurant, Name : "  + request.getName()
//                + "Addresses :" + request.getAddresses()
//                + "Menu[0].name : " + request.getMenus().get(0).getName()
//                + " Menu[0].price : " + request.getMenus().get(0).getPrice();
    }

    // 맛집 수정화기
    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request

    ){

        restaurantService.editRestaurant(restaurantId, request);

        // 서비스에서 수정모듈을 규현하고 나서 주석
//        return "This is editRestaurant, ID : " + restaurantId
//                + "Name : " + request.getName() + "Addresses : " + request.getAddresses();
    }

    // 맛집 삭제
    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        restaurantService.deleteRestaurant(restaurantId);
    }

}
