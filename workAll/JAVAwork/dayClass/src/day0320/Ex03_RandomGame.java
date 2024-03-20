package day0320;

import java.util.Random;
import java.util.Random;
import java.util.Scanner;

public class Ex03_RandomGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String s;

        while (true) {
            System.out.println("게임을 시작하겠습니까?(y/n)");
            s = sc.nextLine();

            if (s.equals("y")) {
                int n = r.nextInt(100) + 1, iInput, iCount = 0;
                System.out.println("숫자를 맞춰보세요.");
                while (true) {
                    iInput = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기
                    iCount++;
                    if (iInput == n) {
                        System.out.println(iCount + "번 만에 맞추셨습니다~");
                        break;
                    } else if (iInput > n) {
                        System.out.println("더 작습니다.");
                    } else if (iInput < n) {
                        System.out.println("더 큽니다.");
                    }
                }
            } else if (s.equals("n")) {
                break;
            }
        }
    }
}
