package day0315;

import java.util.Scanner;

public class Ex7_Scan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int kor,eng;
        String name;
        System.out.println("국어 점수는?");
        kor = Integer.parseInt(sc.nextLine());

        System.out.println("영어 점수는?");
        eng = Integer.parseInt(sc.nextLine());


        System.out.println("이름은?");
        name = sc.nextLine();

        System.out.println("이름 : " + name);
        System.out.printf("국어점수 : %d점 | 영어점수 : %d점\n",kor,eng);
        System.out.printf("총 점 : %d점 평균 : %1.1f점\n",kor+eng, (float)(kor+eng)/2);
        //결과가 double 이여야 할 경우 수식중 하나라도 double 타입이 있어야한다.

    }
}
