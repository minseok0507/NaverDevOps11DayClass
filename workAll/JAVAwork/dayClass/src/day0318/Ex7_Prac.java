package day0318;

import java.util.Scanner;

public class Ex7_Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sName;
        int iMoney, iFamily,iTotal;

        System.out.println("이름을 입력하시오.");
        sName = sc.nextLine();
        System.out.println("기본급을 입력하시오.");
        iMoney = sc.nextInt();
        System.out.println("가족수을 입력하시오.");
        iFamily = sc.nextInt();


        if (iFamily >= 3){
            iTotal= iMoney + (iFamily*50000);
        }else {
            iTotal= iMoney + 30000;
        }

        System.out.printf("""
                이름 : %s
                기본금 : %d
                가족수 : %d
                실수령액 : %d
                """,sName,iMoney,iFamily,iTotal);
    }
}
