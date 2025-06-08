package com.juju.review.repository;

import com.juju.review.model.TestEntity;
import java.util.List;

// dls을 위해 추가
public interface TestRepositoryCustom {

    public List<TestEntity> findAllByNameByQuerydsl(String name);
}
