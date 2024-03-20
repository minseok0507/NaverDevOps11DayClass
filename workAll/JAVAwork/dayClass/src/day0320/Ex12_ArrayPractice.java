package day0320;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Ex12_ArrayPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iNum;

        System.out.println("인원수를 입력하시오.");
        iNum = sc.nextInt();

        int[] iArrKor = new int[iNum], iArrEng = new int[iNum], iArrTot = new int[iNum], iArrRank = new int[iNum];
        String[] sArrName = new String[iNum];

        sc.nextLine(); // 버퍼 비우기

        for (int i = 0; i < iNum; i++) {
            System.out.println(i + 1 + "번째 이름을 입력하시오.");
            sArrName[i] = sc.nextLine();
            System.out.println(i + 1 + "번째 국어 점수를 입력하시오.");
            iArrKor[i] = sc.nextInt();
            System.out.println(i + 1 + "번째 영어 점수를 입력하시오.");
            iArrEng[i] = sc.nextInt();

            sc.nextLine(); // 버퍼 비우기

            iArrTot[i] = iArrEng[i] + iArrKor[i];
        }

        for (int i = 0; i < iArrRank.length; i++) {
            iArrRank[i] = 1;
        }

        for (int i = 0; i < iArrTot.length; i++) {
            for (int j = 0; j < iArrTot.length; j++) {
                if (iArrTot[i] > iArrTot[j]) {
                    iArrRank[j]++;
                }
            }
        }
        System.out.println("-".repeat(25));
        System.out.println("번호\t이름\t국어\t영어\t총점\t등수");
        System.out.println("-".repeat(25));

        for (int i = 0; i < iNum; i++) {
            System.out.println(i + 1 + "\t" + sArrName[i] + "\t" + iArrKor[i] + "\t" + iArrEng[i] + "\t" + iArrTot[i] + "\t" + iArrRank[i]);
        }


    }
}
