package day0326;

import java.util.Scanner;

public class Ex13_Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("두 수 입력");
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if (s1.equals("x") || s2.equals("x"))
                break;
            try {
                int num1 = Integer.parseInt(s1);
                int num2 = Integer.parseInt(s2);
                int sum = num1 + num2;
                System.out.printf("%d + %d = %d\n\n", num1, num2, sum);

            } catch (NumberFormatException n) {
                System.out.println("숫자를 입력하시오" + n.getMessage());
            }

        }
    }
}
