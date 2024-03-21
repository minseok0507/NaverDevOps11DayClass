package day0321;

import java.util.Scanner;

public class Ex04_ArrayAlphaCount {
    public static void main(String[] args) {
        //영어문장 입력 후 알파벳 개수 출력
        Scanner sc = new Scanner(System.in);
        String sMsg;
        int[] iArrApa = new int[26];

        System.out.println("문장을 입력하시오.");
        sMsg = sc.nextLine();

        for (int i = 0; i < sMsg.length(); i++) {
            char ch = sMsg.toUpperCase().charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                iArrApa[ch - 'A']++;
            }

        }

        for (int i = 0; i < iArrApa.length; i++) {
            System.out.printf("%c : %d\t", i + 'A', iArrApa[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

    }
}
