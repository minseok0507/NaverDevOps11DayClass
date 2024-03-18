package day0318;

import java.util.Scanner;

public class Ex13_ForPrac {
    public static void main(String[] args) {
//        System.out.println("지수승 구하기");
//        System.out.println("3의 3승은 " + (int)Math.pow(3,3));
//        System.out.println("2의 4승은 " + (int)Math.pow(2,4));

        Scanner sc = new Scanner(System.in);
        int x, y, iMul;

        System.out.println("숫자 입력");
        x = sc.nextInt();
        System.out.println("지수 입력");
        y = sc.nextInt();

        iMul = 1;

        for (int i = 1; i <= y; i++) {
            iMul *= x;
        }

        System.out.printf("%d 의 %d 승은 %d", x, y, iMul);



    }
}
