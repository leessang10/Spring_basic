package hello.core.singleton;

public class SingletonService {
    // static 변수로 선언하여 전역적으로 사용 가능하게 설정한다.
    private static final SingletonService instance = new SingletonService();
    // instance를 가져오는 방법은 getInstance를 호출하는 방법 뿐이다.
    public static SingletonService getInstance() {
        return instance;
    }
    // private 접근제한자로 새로운 객체 생성(new)을 방지한다.
    private SingletonService() {
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
