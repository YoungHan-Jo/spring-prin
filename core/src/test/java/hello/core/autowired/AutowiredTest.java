package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        // required = false -> 스프링 빈이 존재하지 않으면 메서드 자체를 호출하지 않음
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        // nullable -> 스프링 빈이 존재하지않으면 null로 리턴
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }
        
        // optional<> -> 스프링 빈이 존재하지 않으면 Optional.empty로 리턴
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }

        // **** @Nullable , Optional 은 스프링 전반에 걸쳐서 지원된다.
        // 생성자 자동 주입에서 특정 파라미터에 사용 가능!


    }

}
