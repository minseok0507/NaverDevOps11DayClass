package day0319;

public class Ex02_PracticeFactorial {
    public static void main(String[] args) {
        int iNum = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = i; j >= 1; j--) {
                iNum *= j;

            }
            System.out.println(i + " != " + iNum);
            iNum = 1;
        }
    }
}
