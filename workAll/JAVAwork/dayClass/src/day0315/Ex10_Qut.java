package day0315;

import java.util.Scanner;

public class Ex10_Qut {
    public static void main(String[] args) {
        int money, iMan, iThun, iBak, iTen, iOne;
        Scanner sc = new Scanner(System.in);

        System.out.println("금액 입력");
        money = sc.nextInt();

        iMan = money / 10000;
        iThun = (money % 10000) / 1000;
        iBak = (money % 1000) / 100;
        iTen = (money % 100) / 10;
        iOne = (money % 10) / 1;

        System.out.printf("만원 : %d\n천원 : %d\n백원 : %d\n십원 : %d\n일원 : %d\n", iMan, iThun, iBak, iTen, iOne);

    }
}
