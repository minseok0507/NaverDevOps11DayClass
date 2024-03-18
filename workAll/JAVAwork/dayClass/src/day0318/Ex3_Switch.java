package day0318;

import java.util.Scanner;

public class Ex3_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iNum = 0;
        System.out.println("숫자 1-3 입력하시오");

        iNum = sc.nextInt();
        System.out.println(iNum + "을 입력했습니다.");

        switch (iNum){
            case 1 :
                System.out.println("ONE");
                break;

            case 2 :
                System.out.println("TWO");
                break;

            case 3 :
                System.out.println("THREE");
                break;

            default:
                System.out.println("다른 숫자입니다.");
                break;


        }

    }
}
