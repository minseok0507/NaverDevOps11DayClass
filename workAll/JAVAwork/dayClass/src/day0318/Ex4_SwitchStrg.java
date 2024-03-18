package day0318;

import java.util.Scanner;

public class Ex4_SwitchStrg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sColor;

        System.out.println("색을 입력하시오.");
        sColor = sc.nextLine();

        switch (sColor) {
            case "red":
            case "RED":
                System.out.println("빨강");
                break;

            case "blue":
            case "BLUE":
                System.out.println("파랑");
                break;

            case "green":
            case "GREEN":
                System.out.println("초록");
                break;

            case "black":
            case "BLACK":
                System.out.println("검정");
                break;

            case "white":
            case "WHITE":
                System.out.println("하양");
                break;


            default:
                System.out.println("잘못입력하셨습니다.");

        }


    }
}
