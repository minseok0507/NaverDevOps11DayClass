package day0326;

class OuterClass {
    int a = 10;
    static int b = 20;

    class InnerClass {
        int c = 30;
        static int d = 40;

        public void show() {
            System.out.println("inner class 1 show");
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
        }
    }
    static class InnerClass2{
        int e = 50;
        static int f = 60;
        public void show(){
            System.out.println("inner class 2 show");
            //System.out.println("a = " + a); 인스턴스 변수 접근 불가
            System.out.println("b = " + b);
            System.out.println("e = " + e);
            System.out.println("f = " + f);
        }
    }

    public void disp(){
        InnerClass in = new InnerClass();
        InnerClass2 in2 = new InnerClass2();
        in.show();

        in2.show();
    }
}

public class Ex09_InnerClass {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.disp();
    }
}
