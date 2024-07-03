package ch7.pkg2;
import ch7.pkg1.MyParent;

class MyChild extends MyParent {
    private int prv; // 같은 클래스
    int dft; // 같은 패키지
    protected int prt; // 같은패키지 + 자손(다른 패키지)
    public int pub; // 접근제한 없음

    public void printMembers() {
//        System.out.println(prv); //에러
//        System.out.println(dft); // 에러
        System.out.println(prt);
        System.out.println(pub);
    }

}
public class MyParentTest2 {
    public static void main(String[] args) {
        MyParent p = new MyParent();
//        System.out.println(p.prv); //에러
//        System.out.println(p.dft); //에러
//        System.out.println(p.prt); //에러
        System.out.println(p.pub); //OK
    }
}
