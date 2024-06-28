package ch6;

public class Ex6_1 {
    public static void main(String args[]){
        Tv t; // Tv인스턴스를 참조하기 위한 변수 t 선언
        t = new Tv(); // Tv인스턴스를 생성한다.
        t.channel = 7; // Tv인스턴스의 멤버변수 channel의 값을 7로 초기화
        t.channelDown(); // Tv인스턴스의 메서드 channelDown() 호출
        System.out.println("현재 채널은 " + t.channel + " 입니다.");
    }
}
class Tv {
    //Tv의 속성(멤버변수)
    String color;
    boolean power;
    int channel;
    //Tv의 기능(메서드)
    void power() {power = !power;}
    void channelUp() { ++channel;}
    void channelDown() {--channel;}
}