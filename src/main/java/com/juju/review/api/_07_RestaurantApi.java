package com.juju.review.api;

import com.juju.review.api._07_request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class _07_RestaurantApi {

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
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ){
        return "This is createRestaurant, Name : "  + request.getName()
                + "Addresses :" + request.getAddresses()
                + "Menu[0].name : " + request.getMenus().get(0).getName()
                + " Menu[0].price : " + request.getMenus().get(0).getPrice();
    }

    // 맛집 수정화기
    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request

    ){
        return "This is editRestaurant, ID : " + restaurantId
                + "Name : " + request.getName() + "Addresses : " + request.getAddresses();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        return "This is deleteRestaurant, " + restaurantId;
    }

}
