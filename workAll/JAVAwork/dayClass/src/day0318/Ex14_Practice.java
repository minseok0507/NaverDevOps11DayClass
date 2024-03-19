package day0318;

import java.util.Scanner;

public class Ex14_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iCount = 0, iSum = 0, iScore = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("숫자 입력 " + i + "번째 :");
            iScore = sc.nextInt();
            if (iScore < 0 || iScore > 100) {
                continue;
            }
            iCount++;
            iSum += iScore;
        }
        System.out.println("입력한 점수 개수 : " + iCount + "개");
        System.out.println("총 합계 : " + iSum);


    }
}
