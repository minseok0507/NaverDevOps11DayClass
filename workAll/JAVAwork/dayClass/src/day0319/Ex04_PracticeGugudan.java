package day0319;

public class Ex04_PracticeGugudan {
    public static void main(String[] args) {
        System.out.println("\n\n\n구구단표");
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d X %d = %2d\t\t", j, i, i * j);
            }
            System.out.println();
        }
    }
}
