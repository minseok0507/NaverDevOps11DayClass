package day0319;

public class Ex06_While {
    public static void main(String[] args) {
        int n = 10;
        while (n > 10) {
            System.out.println("Hello #1");
        }
        System.out.println();

        do {
            System.out.println("Hello #2");
        } while (n > 10);

        int a = 1;
        while (a < 10) {
            System.out.printf("%-3d", a++);
        }
        System.out.println();

        a = 1;
        while (true){
            System.out.printf("%-3d", a++);
            if (a > 10){
                break;
            }
        }

        System.out.println();

        char ch = 'A';
        while (ch <= 'Z'){
            System.out.printf("%-3c", ch++);
        }

    }
}
