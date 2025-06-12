package com.juju.review.repository;

import com.juju.review.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuReposotory extends JpaRepository<MenuEntity, Long> {

    public List<MenuEntity> findAllByRestaurantId(Long restaurantId);

}
