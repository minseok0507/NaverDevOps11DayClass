package day0327;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex03_SetLotto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> setLotto = new TreeSet<>();

        Exit:
        while (true) {
            System.out.println("금액 입력/0 입력시 종료");
            int money = sc.nextInt();
            if (money == 0) {
                System.out.println("종료합니다.");
                break Exit;
            } else if (money < 1000) {
                System.out.println("금액 부족");
            }
            for (int i = 0; i < money / 1000; i++) {
                setLotto.clear();

                while (true) {
                    int n = (int) (Math.random() * 45) + 1;
                    setLotto.add(n);
                    if (setLotto.size() == 6)
                        break;
                }
                System.out.printf("%3d번째 : ",i+1);
                for (int s : setLotto) {
                    System.out.printf("%3d",s);
                }
                System.out.println();

            }

        }
    }
}
