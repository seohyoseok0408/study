package ch6;
// 기본형 매개변수 예제
// 값을 읽기만 할 수 있다.
class DataEx {
    int x;
}
public class Ex6_6 {
    public static void main(String[] args){
        DataEx d = new DataEx();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);

    }

    static void change(int x){ // 기본형 매개변수
        x = 1000;
        System.out.println("change() : x = " + x);
    }
}
