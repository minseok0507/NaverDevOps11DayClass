package day0321;

import java.util.Scanner;

public class Ex11_ArrayPractice {
    public static void main(String[] args) {
        /*
         * -------------------------------
         * 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
         * 최고점수 / 평균
         * */

        int iStudent = 0, iSum = 0, iInput, iHight = 0;
        double dAvg = 0;
        int[] iScore = new int[0];
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-".repeat(50));
            System.out.println("  1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("-".repeat(50));
            iInput = sc.nextInt();

            if (iInput == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (iInput == 1) {
                System.out.println("학생수를 입력하시오.");
                iStudent = sc.nextInt();
                iScore = new int[iStudent];
            } else if (iInput == 2) {
                if (iStudent == 0) {
                    System.out.println("1을 눌러 학생수를 입력하시오.");
                } else {
                    for (int i = 0; i < iStudent; i++) {
                        System.out.println("학생" + (i + 1) + " 점수를 입력하시오.");
                        iScore[i] = sc.nextInt();
                        iSum += iScore[i];
                    }
                    System.out.println("입력이 끝났습니다.");
                }
            } else if (iInput == 3) {
                for (int i = 0; i < iStudent; i++) {
                    System.out.println("학생" + (i + 1) + " 점수 : " + iScore[i]);
                }
            } else if (iInput == 4) {
                dAvg = (double) iSum / iStudent;
                for (int i = 0; i < iScore.length - 1; i++) {
                    for (int j = i + 1; j < iScore.length; j++) {
                        if (iScore[i] < iScore[j]) {
                            iHight = iScore[j];
                        }
                    }
                }
                System.out.printf("최고 점수 : %d\n평 균\t: %2.1f\n", iHight, dAvg);
            }
        } while (true);


    }
}
