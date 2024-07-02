package ch7.pkg1;

public class MyParent { // 접근제어자가 public
    private int prv; // 같은 클래스
    int dft; // 같은 패키지
    protected int prt; // 같은패키지 + 자손(다른 패키지)
    public int pub; // 접근제한 없음

    public void printMembers() {
        System.out.println(prv);
        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }

}
class MyParentTest { // 접근제어자가 default
    public static void main(String[] args) {
        MyParent p = new MyParent();
//        System.out.println(p.prv); //에러
        System.out.println(p.dft);
        System.out.println(p.prt);
        System.out.println(p.pub);
    }
}
