package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", // 스캔할 패키지 설정
//        basePackageClasses = AutoAppConfig.class, //  클래스를 포함한 패키지를 스캔,
//        디폴트 값은 @ComponentScan 애노태이션을 붙인 클래스를 포함한 패키지가 기준
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)// 예시를 위해 configuration 애노테이션은 제외
public class AutoAppConfig {

}
