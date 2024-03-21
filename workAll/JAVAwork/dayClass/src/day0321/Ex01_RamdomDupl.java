package day0321;

import java.util.Random;

public class Ex01_RamdomDupl {
    public static void main(String[] args) {
        Random r = new Random(30);
        int[] rand = new int[10];

        Loop:
        for (int i = 0; i < rand.length; i++) {
            int n = (int) (Math.random() * 30) + 1;
            rand[i] = n;
            for (int j = 0; j < i; j++) {
                if (rand[i] == rand[j]) {
                    i--;
                    continue Loop;
                }

            }

        }
        System.out.println("1 ~ 30 중복 아닌 난수");
        for (int i = 0; i < rand.length - 1; i++) {
            for (int j = i + 1; j < rand.length; j++) {
                if (rand[i] > rand[j]) {
                    int temp = rand[i];
                    rand[i] = rand[j];
                    rand[j] = temp;
                }
            }
        }
        for (int i = 0; i < rand.length; i++) {
            System.out.print(rand[i] + " ");
        }

    }
}
