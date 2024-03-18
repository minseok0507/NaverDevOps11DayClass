package day0318;

import java.util.Scanner;

public class Ex1_Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iScor;
        String sInput;


        System.out.println("점수를 입력하시오.");
        iScor = sc.nextInt();

        if (iScor > 100 || iScor < 1) {
            System.out.println("점수를 잘못입력하셨습니다.");
        }
        else {
            sInput = iScor >= 90 ? "A" :
                        iScor >= 80 ? "B" :
                            iScor >= 70 ? "C" :
                                iScor >= 60 ? "D" : "F";

            System.out.println(iScor + "점은 " + sInput + "학점 입니다.");
        }
    }
}
