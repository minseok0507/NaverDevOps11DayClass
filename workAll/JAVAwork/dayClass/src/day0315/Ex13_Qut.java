package day0315;

import java.util.Scanner;

public class Ex13_Qut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score;
        String msg;

        System.out.println("점수를 입력하시오.");
        score = sc.nextInt();

        msg = score >= 90 ? "참 잘했어요!" :
                score >= 80 ? "수고했어요" :
                        score >= 70 ? "조금 더 노력하세요" : "재시험";


        System.out.println(msg);


    }

}
