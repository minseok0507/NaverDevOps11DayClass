package day0315;

public class Ex2_DateType {
    public static void main(String[] args){
        byte a = 127;
        System.out.println(a);

        byte b = (byte) 200; //(byte) = cast연산자:강제로 형변환/값손실 발생
        System.out.println(b); //값손실이 발생할 경우 엉뚱한 값이 출력(<<2의 보수값)


        //실수 타입
        float f1 = 12.41353734F; //f를 붙어야 4바이트 float으로 저장
        double f2 = 123.12314123;

        System.out.println(f1); //8자리까지 정확히 나옴
        System.out.println(f2); //15자리까지 정확히 나옴

    }
}
