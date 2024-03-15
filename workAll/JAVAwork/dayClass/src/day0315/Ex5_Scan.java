package day0315;

import java.util.Scanner;

public class Ex5_Scan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //키보드로부터 입력받는 인스턴스 변수
//        String msg = "";
//        System.out.println("메세지를 입력하세요");
//        msg = sc.nextLine();//한줄을 통째로 읽는다.
//        System.out.println("입력한 문자열은 \"" + msg + "\"입니다.");

        int age;
        System.out.println("당신의 나이는?");

//        age =sc.nextInt();

        age = Integer.parseInt(sc.nextLine()); //입력받을 값을 정수타입으로 변환
        System.out.println("당신의 나이는 " + age + "세 입니다.");

    }
}
