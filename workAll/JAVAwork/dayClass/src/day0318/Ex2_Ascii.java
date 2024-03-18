package day0318;

public class Ex2_Ascii {
    public static void main(String[] args) {
        char a = 'A';
        char b = 65;

        System.out.println(a + ", " + b);
        System.out.printf("a = %d, a = %c\n", (int) a, a);
        System.out.println(a+3);
        System.out.println((char)(a+3));

        char c = '7';
        System.out.println(c);
        System.out.println(c+2);

        int n1 = c -'0';
        System.out.println(n1);
        System.out.println(n1+2);
    }
}
