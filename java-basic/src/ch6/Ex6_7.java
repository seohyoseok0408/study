package ch6;

// 참조형 매개변수 예제
class Data2 { int x; }
public class Ex6_7 {
    public static void main(String[] args) {
        Data2 d = new Data2();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d);
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x);

    }

    // 객체를 다룰 수 있는 리모콘을 넘겨줌. 주소를 넘겨줌
    static void change(Data2 d){ // 참조형 매개변수
        d.x = 1000; // 객체의 주소를 아니까 읽기 쓰기가 가능
        System.out.println("change() : x = " + d.x);
    }
}