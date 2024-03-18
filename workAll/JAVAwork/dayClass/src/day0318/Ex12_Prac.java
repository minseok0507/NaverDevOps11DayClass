package day0318;

import java.util.Scanner;

public class Ex12_Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iInput;

        System.out.println("구구단");
        iInput = sc.nextInt();

        if (iInput > 9 || iInput < 2) {
            System.out.println("(2~9단만 입력하시오)");
        } else {
            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d X %d = %2d\n", iInput, i, iInput * i);
            }
        }


        System.out.println("\n\n\n구구단표");
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d X %d = %2d\t\t", j, i, i * j);
            }
            System.out.println();
        }


    }
}
