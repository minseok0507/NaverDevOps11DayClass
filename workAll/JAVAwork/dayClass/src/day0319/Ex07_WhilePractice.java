package day0319;

import java.util.Scanner;

public class Ex07_WhilePractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iSum = 0, iCount = 0, iInput;

        while (true) {
            System.out.println("점수를 입력하시오.('0' 입력 시 종료)");
            iInput = sc.nextInt();

            if (iInput > 100 || iInput < 0) {
                System.out.println("1점 이상 100점 이하로 입력하시오.");
                continue;
            }

            if (iInput == 0) {
                break;
            }
            iSum += iInput;
            iCount++;
        }

        System.out.printf("""
                입력한 개수 : %d
                점수 합 : %d
                """, iCount, iSum);
    }
}
