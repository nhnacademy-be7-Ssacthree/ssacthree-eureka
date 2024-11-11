package org.nhnacademy.ssacthree_eureka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SsacthreeEurekaApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        // 애플리케이션 컨텍스트가 null이 아닌지 확인하여 로드 여부 테스트
        assertDoesNotThrow(() -> {
            // ApplicationContext가 정상적으로 로드되면 예외가 발생하지 않음
            applicationContext.getBean(SsacthreeEurekaApplication.class);
        });
    }

    @Test
    void testMainMethodRunsWithoutExceptions() {
        // main 메서드가 실행될 때 예외가 발생하지 않는지 확인
        assertDoesNotThrow(() -> {
            SsacthreeEurekaApplication.main(new String[]{});
        });
    }
}