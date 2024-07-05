package ch7;
public class Ex7_34 {
    public static void main(String[] args) {
//        Unit[] group = {new Marine(), new Tank(), new Dropship()};

        Unit[] group = new Unit[3];
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new Dropship();

//        for (int i=0; i<group.length;i++){
//            group[i].move(100, 200);
//        }

        // group의 타입은 Unit[], group[0], group[1], group[2]의 타입은 Unit
        group[0].move(100, 200); // Marine객체의 move(100,200)을 호출
        group[1].move(100, 200);
        group[2].move(100, 200);
    }

}

abstract class Unit {
    int x, y;
    abstract void move(int x,int y);
    void stop(){ /* 현재 위치에 정지 */ }
}

class Marine extends Unit {
    void move (int x, int y) {
        System.out.println("Marine[x=" + x + "y=" + y + "]");
    }
    void stimPack() {/*stimPack 사용*/ }
}

class Tank extends Unit {
    void move (int x, int y) {
        System.out.println("Tank[x=" + x + "y=" + y + "]");
    }
    void changeMode() {/*changeMode 사용*/ }
}

class Dropship extends Unit {
    void move (int x, int y) {
        System.out.println("Dropship[x=" + x + "y=" + y + "]");
    }
    void airShot() {/*airShot 사용*/ }
}
