package ch7;

// Overried Test

class Point {
    int x;
    int y;
    String getLocation() {
        return "x:"+x+", y:"+y;
    }
}

class MyPoint3D extends Point {
    int z;

    // 조상의 getLocation() 을 오버라이딩
    String getLocation() {
        return "x:"+x+", y:"+y+", z:"+z;
    }
}
public class Ex7_7 {
    public static void main(String[] args) {
        MyPoint3D p = new MyPoint3D();
        p.x = 3;
        p.y = 5;
        p.z = 7;
        System.out.println(p.getLocation());
    }
}
