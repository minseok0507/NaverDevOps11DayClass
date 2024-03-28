package day0328;

/*
 * 자바에서 함수형 프로그램 Lambda 표현식
 *
 */

@FunctionalInterface //메서드가 하나인지 검증
interface Orange{
    public void write();
}

@FunctionalInterface
interface DateAdd{
    public void add(int x, int y);
}
public class Ex02_Lambda {

    Orange o = new Orange() {
        @Override
        public void write() {
            System.out.println("오렌지 냠냠");
        }
    };

    public void lambdaMethod(){
        Orange o2;
        o2 = () -> System.out.println("람다식 오렌지 호출");
        o2.write();

        Orange o3 = () -> {
            System.out.println("람다식");
            System.out.println("gogo");
        };

        o3.write();
    }

    public void lambdaMethod2(){
        DateAdd add1 = (int x, int y) -> System.out.println("두 수의 합 : " + (x+y));

        add1.add(10,20);
    }

    public static void main(String[] args) {
        Ex02_Lambda ex = new Ex02_Lambda();
        ex.o.write();
        ex.lambdaMethod();

        ex.lambdaMethod2();
    }
}
