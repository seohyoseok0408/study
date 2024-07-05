package ch7;

abstract class Unit2 {
    int x, y;
    abstract void move(int x, int y);
    void stop() {
        System.out.println("멈춘다.");
    }
}

interface Fightable {
    void move(int x, int y); // public abstract가 생략됨
    void attack(Fightable f); // public abstract가 생략됨
}

class Fighter extends Unit2 implements Fightable {
    // 오버라이딩 규칙 : 조상(public)보다 접근제어자가 범위가 좁으면 안된다.
    public void move(int x, int y) {
        System.out.println("["+x+", "+y+"]로 이동");
    }
    public void attack(Fightable f) {
        System.out.println(f+"를 공격");
    }

    Fightable getFightable() {
        Fighter f = new Fighter(); // Fighter을 생성해서 반환
        return f; // 원래는 (Fighterable)f
    }
}
public class Ex7_38 {
    public static void main(String[] args) {
        Fighter f = new Fighter();

        Fightable f2 = f.getFightable();

    }
}
