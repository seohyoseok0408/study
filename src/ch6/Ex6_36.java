package ch6;
// 생성자 this()

class Car {
    String color;
    String gearType;
    int door;

    Car () {
//        color = "White";
//        gearType = "auto";
//        door = 4;

        this("white", "auto", 4); // 위 코드의 중복을 제거
        // 아무 것도 매개변수로 넘기지 않았을 때 초기화
    }

    Car (String c, String g, int d) {
        color = c;
        gearType = g;
        door = d;
    }
}
public class Ex6_36 {
}
