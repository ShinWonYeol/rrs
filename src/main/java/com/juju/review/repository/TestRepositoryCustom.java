package com.juju.review.repository;
// 커스텀  메서드를 정의(선언)하는 인터페이스
import com.juju.review.model.TestEntity;
import java.util.List;

// dls을 위해 추가
public interface TestRepositoryCustom {

    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
