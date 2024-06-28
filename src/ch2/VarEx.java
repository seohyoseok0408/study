package ch2;

public class VarEx {
    public static void main(String[] args) {
        int score = 100;
        score = 200;

        final int score2 = 100;
//        score2 = 200; //error

        int score3;
        score3 = 100; //초기화 안할 시 에러
        System.out.println(score);
        System.out.println(score2);
        System.out.println(score3);
    }
}
