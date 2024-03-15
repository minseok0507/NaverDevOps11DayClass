package day0315;

import java.util.Scanner;

public class Ex6_Scan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int kor,eng;
        String name;
        System.out.println("국어 점수는?");
        kor = sc.nextInt();
        System.out.println("영어 점수는?");
        eng = sc.nextInt();

        //버퍼의 엔터를 읽어 소멸
        sc.nextLine();

        System.out.println("이름은?");
        name = sc.nextLine(); //점수 뒤의 엔터를 읽어온다(버퍼에 엔터가 저장되어 있음)

        System.out.println("이름 : " + name);
        System.out.printf("국어점수 : %d점 | 영어점수 : %d점\n",kor,eng);
        System.out.printf("총 점 : %d점 평균 : %d점\n",kor+eng, (kor+eng)/2);



    }

}
