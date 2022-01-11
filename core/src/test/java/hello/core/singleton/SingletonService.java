package hello.core.singleton;

public class SingletonService {

    //1. static 영역에 객체 instance를 1개만 생성해 둔다
    private static final SingletonService instance = new SingletonService();

    //2. 객체가 필요할때는 오직 이 static 메서드를 통해서만 instance를 꺼내서 사용할 수 있음
    public static SingletonService getInstance() {
        return instance;
    }
    // 위 까지만 하면 새로운 객체 생성 가능하기 때문에 private로 기본생성자를 막아야함
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
