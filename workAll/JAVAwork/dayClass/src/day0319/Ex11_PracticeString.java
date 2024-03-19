package day0319;

import java.util.Scanner;

public class Ex11_PracticeString {
    public static void main(String[] args) {
        String msg;
        int big = 0, small = 0, num = 0, other = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("문자 입력");
        msg = sc.nextLine();

        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z') {
                big++;
            } else if (msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z') {
                small++;
            } else if (msg.charAt(i) >= '0' && msg.charAt(i) <= '9') {
                num++;
            } else {
                other++;
            }
        }

        System.out.printf("""
                %s
                대문자 : %d
                소문자 : %d
                숫 자 : %d
                기 타 : %d
                """, msg, big, small, num, other);

    }
}
