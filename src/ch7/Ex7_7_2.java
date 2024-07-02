package ch7;

// Overried Test

class Point2 extends Object {
    // Object 상속은 생략 가능
    int x;
    int y;
    String getLocation() {
        return "x:"+x+", y:"+y;
    }
}

class MyPoint3D2 extends Point {
    int z;

    MyPoint3D2 (int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    // Object클래스의 toString()을 오버라이딩
    public String toString() {
        return "x:"+x+", y:"+y+", z:"+z;
    }
}
public class Ex7_7_2 {
    public static void main(String[] args) {
        MyPoint3D2 p = new MyPoint3D2(3, 5, 7);
//        p.x = 3;
//        p.y = 5;
//        p.z = 7;
        System.out.println(p);
//        System.out.println(p.toString());
        // p 쓴거나 p.toString() 쓴거나 같다.
    }
}
