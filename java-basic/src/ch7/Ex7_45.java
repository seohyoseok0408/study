package ch7;

import java.time.chrono.IsoChronology;

public class Ex7_45 {
    class InstanceInner {
        int iv = 100;
        static int cv = 100;
        final static int CONST = 100;
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 200;
    }

    void myMethod() {
        class LocalInner {
            int iv = 300;
            static int cv = 300;
            final static int CONST = 300;
        }
    }
    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);

//        System.out.println(LocalInner.CONST); // 에러. 지역 내부 클래스는 메서드 내에서만
    }
}





class Outer {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv; // 외부 클래스의 private 멤버도 접근 가능하다.
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // static 클래스는 외부 클래스의 인스턴스 멤버와 접근할 수 없다.
        int siv = outerCv;
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0; // JDK1.8부터 final 생략 가능
        // 웬만하면 final 상수 붙이기

        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;

            // 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능하다.
            int liv3 = lv; // final int liv로 final이 생략됐기에 원래 에러지만, 괜찮다.
            int liv4 = LV;
        }
    }
}