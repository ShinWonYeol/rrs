package com.juju.review.repository;
// 커스텀을 구현한 클래스로 Impl로 이름이 끝나야 한다.
import com.juju.review.model.QTestEntity;
import com.juju.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl  implements TestRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    // TestRepositoryCustom 추상 메서드를 오버라이딩 TestRepositoryCustom 타입으로 접근 가능
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity).
                where(QTestEntity.testEntity.name.eq(name)).fetch();
    }
}

