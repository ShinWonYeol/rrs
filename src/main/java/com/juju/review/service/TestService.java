package com.juju.review.service;
// 비즈니스 로직 처리 역할로 레포지토리를 호출하여 실제 DB 작업 수행하는 역할
// 레포지토리 작성 후 작성

import com.juju.review.model.TestEntity;
import com.juju.review.repository.TestRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// 매개 변수를 생성
@AllArgsConstructor
@Service
public class TestService {
    // TestEntity 갹체를 Curd 할 수 있는 인터페이스
    private final TestRepository testRepository;

    // @AllArgsConstructor이 없다면 아래와 같이 만들어 줘야함
//    public TestService(TestRepository testRepository){
//        this.testRepository = testRepository;
//    }

    public void create(String name, Integer age){
        TestEntity testEntity = new TestEntity(name, age);
        // JpaRepository 를 TestRepository 인터페이스가 상속받은 save, delete, findById와 같은 메소드 자동 구현 가능
        // 또한 생성자가 @AllArgsConstructor 되어 있긴 하지만
        testRepository.save(testEntity);

    }

    public void delete(Long id){
        TestEntity testEntity = testRepository.findById(id).get();
        testRepository.delete(testEntity);
    }


    // 업데이트는 무엇을 업데이트 해야되는지 알아야 하니 id, 이름, 나이 모두 받기
    public void update(Long id, String name, Integer age){
        // 이전에 저장된 id 값을 불러옴
        TestEntity testEntity = testRepository.findById(id).orElseThrow();
        // 새로운 값으로 업데이트를 위해 TestEntity에서 업데이트문 정의
        // 변경하는 메소드에 값을 전달
        testEntity.changeNameAndAge(name, age);
        testRepository.save(testEntity);

    }

    // jpa를 통해 조회를 하기 위한 구문
    public List<TestEntity> findAllByNameByJPA(String name){
            return testRepository.findAllByName(name);
        }

    // dls을 위한 구문
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return testRepository.findAllByNameByQuerydsl(name);
    }

}
