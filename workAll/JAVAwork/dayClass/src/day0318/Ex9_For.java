package day0318;

public class Ex9_For {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 10; i >= 1; i--) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 0; i <= 10; i += 3) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.printf("%4c", i);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.printf("%3d", i);
            if (i == 5) {
                break;
            }
        }
        System.out.println();


    }
}
