package ch7;

class AA { // AA는 BB의 외부 클래스
    int i = 100;
    BB b = new BB();

    class BB { // BB는 AA의 내부 클래스
        void method() {
//            AA a = new AA();
//            System.out.println(a.i);
            System.out.println(i); //객체 생성 없이 외부 클래스의 멤버 접근가능
        }
    }
}

class CC {
}

public class Ex7_42 {
    public static void main(String[] args) {
//        BB b = new BB();
//        b.method();

    }
}
