package com.juju.review.service;

import com.juju.review.api._07_request.CreateAndEditRestaurantRequest;
import com.juju.review.model.MenuEntity;
import com.juju.review.model.RestaurantEntity;
import com.juju.review.repository.MenuReposotory;
import com.juju.review.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
// RequiredArgsConstructor 는 필수 필드만을 가진 생성자
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuReposotory menuReposotory;

    @Transactional
    // 여러 테이블이 있는 경우 하나의 트랙션으로 묶기 위해 필요
    public RestaurantEntity createRestaurant(
            // 사용자가 전달해준 CreateAndEditRestaurantRequest 형태의 객체를 받음
            CreateAndEditRestaurantRequest request
    ){
        RestaurantEntity restaurant = RestaurantEntity.builder()
                // 사용자가 전달해준 객체에서 get을 통해 값 꺼내오기(@getter 덕분에 가능)
                .name(request.getName())
                .addresses(request.getAddresses())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        // 메뉴에서 레스토랑의 ID를 저장하기 위해 먼저 사용자가 전달한 ID를 저장
        restaurantRepository.save(restaurant);
        // foreach의 람다 표현식
        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();

            menuReposotory.save(menuEntity);

                });



        return restaurant;
    }

    @Transactional
    public void editRestaurant(
            Long restaurantId ,
            CreateAndEditRestaurantRequest request
    ){
       RestaurantEntity restaurant =  restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는 레스토랑 입니다."));
        restaurant.changeNameANdAddresses(request.getName(), request.getAddresses());
        restaurantRepository.save(restaurant);

        // 수정을 위해 현재 수정하려는 레스토랑의 메뉴를 모두 삭제
        List<MenuEntity> menus = menuReposotory.findAllByRestaurantId(restaurantId);
        menuReposotory.deleteAll(menus);

        request.getMenus().forEach(menu -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();

            menuReposotory.save(menuEntity);
        });

    }

    @Transactional
    public void deleteRestaurant(Long restaurantId){
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는 레스토랑 입니다."));
        restaurantRepository.delete(restaurant);

        List<MenuEntity> menus = menuReposotory.findAllByRestaurantId(restaurantId);
        menuReposotory.deleteAll(menus);

    }
}
