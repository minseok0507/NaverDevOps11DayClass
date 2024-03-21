package day0321;

import java.util.Random;
import java.util.Scanner;

public class Ex06_ArrayLotto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money;


        while (true) {
            System.out.println("로또 금액 입력 ");
            money = sc.nextInt();
            if (money == 0) {
                System.out.println("종료합니다.");
                break;
            } else if (money < 1000) {
                System.out.println("금액이 부족합니다.");
            } else {
                for (int iNum = 0; iNum < (money / 1000); iNum++) {

                    int[] lotto = new int[6];

                    Loop:
                    for (int i = 0; i < lotto.length; i++) {
                        int n = (int) (Math.random() * 45) + 1;
                        lotto[i] = n;
                        for (int j = 0; j < i; j++) {
                            if (lotto[i] == lotto[j]) {
                                i--;
                                continue Loop;
                            }

                        }

                    }
                    for (int i = 0; i < lotto.length - 1; i++) {
                        for (int j = i + 1; j < lotto.length; j++) {
                            if (lotto[i] > lotto[j]) {
                                int temp = lotto[i];
                                lotto[i] = lotto[j];
                                lotto[j] = temp;
                            }
                        }
                    }
                    System.out.print((iNum + 1) + "회 : ");
                    for (int i = 0; i < lotto.length; i++) {
                        System.out.printf("%2d ", lotto[i]);
                    }
                    System.out.println();

                }
            }


        }
    }

}
