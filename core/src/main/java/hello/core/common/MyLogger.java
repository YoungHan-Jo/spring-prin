package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS) // 이 빈은 http 요청 당 하나씩 생성되고, http 요청이 끝나는 시점에 소멸된다.
public class MyLogger { // proxyMode 를 넣으면 provider 넣은거처럼 동작함 // 적용 대상이 클래스면 TARGET_CLASS, 인터페이스면 INTERFACES
                        // 가짜 프록시 클래스를 등록함

    private String uuid;
    private String requestURL;

    // 빈이 생성되는 시점에는 알 수 없으므로 외부에서 setter로 입력받음
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] [" + requestURL + "] " + message);
    }

    @PostConstruct // 초기화 메서드를 사용해서 uuid를 생성해서 저장해둔다. // http 요청 당 하나씩 생성되므로 다른요청들과 구분가능.
    public void init(){
         uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}
