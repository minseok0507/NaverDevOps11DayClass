package day0325;

class Parent2{
    public void job(){
        System.out.println("부모클래스에서 해야할 일 처리...");
    }
}

class Sub2 extends Parent2{
    @Override
    public void job() {
        super.job(); //부모호출시 반드시 super 로 호출
        System.out.println("자식 클래스에서 처리할 일");
    }
}
public class Ex06_Override {
    public static void main(String[] args) {
        Sub2 s = new Sub2();
        s.job();
    }
}
