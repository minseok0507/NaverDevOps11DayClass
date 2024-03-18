package day0318;

import java.util.Scanner;

public class Ex6_ScoreSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iScor;
        String sInput;

        System.out.println("점수를 입력하시오.");
        iScor = sc.nextInt();

//        switch (iScor / 10) {
//            case 10, 9:
//                sInput = "A";
//                break;
//
//            case 8:
//                sInput = "B";
//                break;
//
//            case 7:
//                sInput = "C";
//                break;
//
//            case 6:
//                sInput = "D";
//                break;
//
//            default:
//                sInput = "F";
//
//        }
        if (iScor >= 90) {
            sInput = "A";
        } else if (iScor >= 80) {
            sInput = "B";
        } else if (iScor >= 70) {
            sInput = "C";
        } else if (iScor >= 60) {
            sInput = "D";
        } else {
            sInput = "F";
        }
        System.out.println(iScor + "점은 " + sInput + "학점입니다.");

    }
}
