package day0322;

public class Ex01_Object {
    String name = "홍길동";
    final static int MAX = 100;

    public static void main(String[] args) {
        System.out.println(Ex01_Object.MAX);
        System.out.println(MAX);

        Ex01_Object ex = new Ex01_Object();
        System.out.println(ex.name);

        Apple ap = new Apple();
        System.out.println(ap.mag);
        System.out.println(Apple.message);

        Banana ba = new Banana();

        System.out.println(Banana.eng + Banana.kor);
        System.out.println(ba.name);


    }
}

class Apple{
    String mag = "Happy Day";
    static String message = "오늘은 금요일";
}

class Banana {
    static int kor = 70;
    static int eng = 84;
    String name = "이름";
}