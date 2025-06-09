package com.juju.review.repository;
// DB에 CRUD 요청하는 역할
// model에서 테이블 정의 후 작성
import com.juju.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
// TestEntity 객체의 Long 타입의 ID를 기준으로 CRUD 를 하겠다
// TestRepositoryCustom은 api에서 dsl 사용을 위해 상속을 받았고 findAllByNameByQuerydsl()을 실행하면 오버라이딩 했기에 TestRepositoryCustom 타입으로 TestRepositoryImpl의 메서드를 사용 가능
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom{
// JpaRepository의 2번째 인자값은 TestEntity 엔티티 부분에서 @id 어노테이션이 있는 필드 (pk)를 전달
// 이 코드는 "TestEntity라는 클래스를 Long 타입의 기본키로 CRUD 할 수 있는 Repository 인터페이스를 만들겠다"는 의미

    // dsl을 위한 구문
    public List<TestEntity> findAllByName(String name);
    // 결과값이 여러개 있을 수 있으니 List형 타입으로 선언
    // findAllByName는 JPA의 쿼리 매서드 기능으로 SELECT * FROM test WHERE name = ?; 와 같은 구문을 자동으로 만듦
    // api 부분에서 return testService.findAllByNameByJPA("juju");가 넘어가면 name이 juju인 게 넘어감
    // api 부분에서 RequestParm에 들어온 값이 name으로 넘어감
}
