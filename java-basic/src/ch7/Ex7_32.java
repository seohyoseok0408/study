package ch7;

abstract class  Player { // 추상 클래스(미완성 클래스, 미완성 설계도)
    abstract void play(int pos); // 추상 메서드(미완성 메서드)
    abstract void stop(); // 추상 메서드
}

class AudioPlayer extends Player {
    void play(int pos){
        System.out.println(pos + "위치부터 play 합니다.");
    }
    void stop() {
        System.out.println("재생을 멈춥니다.");
    }
}
public class Ex7_32 {
    public static void main(String[] args) {
//        Player p = new Player();
//        AudioPlayer ap = new AudioPlayer();

        // Player 리모콘은 play stop 버튼이 있어서 가능. 다형성
        Player ap = new AudioPlayer();


        ap.play(100);
        ap.stop();
    }
}
