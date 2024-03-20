package day0320;

public class Ex01_MathRandom {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            double d = Math.random();
            System.out.println(d);
        }
        System.out.println();
        System.out.println("2. 0~9 발생");
        for (int i = 0; i < 5; i++) {
            double d = Math.random();
            int n = (int)(d*10);
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.println("3. 1~10 발생");
        for (int i = 0; i < 5; i++) {
            double d = Math.random();
            int n = (int)(d*10)+1;
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.println("4. 1~100 발생");
        for (int i = 0; i < 5; i++) {
            double d = Math.random();
            int n = (int)(d*100)+1;
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.println("5. A~Z 발생");
        for (int i = 0; i < 5; i++) {
            double d = Math.random();
            int n = (int)(d*26)+'A';
            System.out.printf("%c ",n);
        }

        System.out.println();
        System.out.println("6. a~z 발생");
        for (int i = 0; i < 5; i++) {
            double d = Math.random();
            int n = (int)(d*26)+'a';
            System.out.printf("%c ",n);
        }
    }
}
