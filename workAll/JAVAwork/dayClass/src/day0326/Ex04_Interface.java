package day0326;

interface InterA {
    int MAX = 10;           //final 생략

    public void disp();     //abstract 생략

    public void study();
}

class MyInter implements InterA {
    @Override
    public void disp() {
        System.out.println("MAX : " + InterA.MAX);
    }

    @Override
    public void study() {
        System.out.println("인터페이스 공부");
    }

    public void play(){
        System.out.println("PLAY");
    }
}

public class Ex04_Interface {
    public static void main(String[] args) {
        InterA my = new MyInter();
        my.disp();
        my.study();
        ((MyInter)my).play(); //서브클레스로 형변환
    }

}
