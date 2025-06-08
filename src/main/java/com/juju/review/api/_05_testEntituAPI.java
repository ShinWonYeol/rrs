package com.juju.review.api;
// http 요청 처리 받기
import com.juju.review.model.TestEntity;
import com.juju.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.weaver.ast.Test;
import org.springframework.web.bind.annotation.*;




@AllArgsConstructor
@RestController
public class _05_testEntituAPI {

    private final TestService testService;

    // @AllArgsConstructor 어노테이션에 의해 생략된 생성자, 해당 클래스가 jvm에 의해 실행되어 생성되는것으로 보임
//    public _05_testEntituAPI(TestService testService){
//        this.testService = testService;
//    }

    // 이미 지정된 값을 전달하여 컬럼 생성
    @GetMapping("/test/entity/create")
    public void getCreateTestEntity(){
        // 위 @AllArgsConstructor 으로 TestService 타입의 객체가 생성되었기 때문에 바로 메소드 사용 가능
        testService.create("wyshin", 28);
    }

    // 사용자가 전달해주는 값을 칼럼으로 생성하기 위해 만들어진 생성을 위한 클래스
    @AllArgsConstructor
    @Getter
    public static class CreateTestEntityRequest{
        private final String name;
        private final Integer age;

    }

    @PostMapping("/test/entity/create")
    public void postCreateTestEntity(
            @RequestBody CreateTestEntityRequest request
    ){
        testService.create(request.getName(), request.getAge());
    }

    // 삭제는 보통 Path를 사용함
    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable Long id
    ){
        testService.delete(id);
    }

    @AllArgsConstructor
    @Getter
    public static class UpdateTestEntityRequest{
        private final String name;
        private final Integer age;

    }

    @PutMapping("/test/entity/{id}")
    public void PutTestEntity(
            @PathVariable Long id,
            @RequestBody UpdateTestEntityRequest request
    ){
        testService.update(id, request.name, request.age);
    }

}
