package day0326;

import java.util.Date;

public class Ex14_Exception {
    static public void go1() throws NullPointerException, NumberFormatException{
        //Date date = null;
        Date date = new Date();
        System.out.println(date.getYear());

        String a = "12";
        int n = Integer.parseInt(a);
        System.out.println(n + 10);

    }

    public static void main(String[] args) {
        try {
            go1();
        } catch (NullPointerException e) {
            System.out.println("클래스 생성 안하고 호출 " + e.getMessage());
        } catch (NumberFormatException n){
            System.out.println("숫자 변환 오류 " + n.getMessage());
        }finally {
            System.out.println("finally 무조건 실행");
        }

        System.out.println("정상 종료");
    }

}
