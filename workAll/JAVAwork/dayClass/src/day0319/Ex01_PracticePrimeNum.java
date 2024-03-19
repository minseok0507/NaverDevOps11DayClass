package day0319;

public class Ex01_PracticePrimeNum {
    public static void main(String[] args) {
//        int p = 2, n = 3;
//        while (true) {
//            double t = Math.sqrt(n);
//            int m = (int) t;
//            for (int i = 2; i <= m; i++) {
//                int r = n % i;
//                if (r == 0) break;
//                if (i == m) p = n;
//            }
//            if (p == n) System.out.print(p + "\t");
//            n++;
//            if (n > 100) break;
//        }
//        System.out.println();


//        int p = 2, iCount = 0;
//        for (int n = 2; n < 100; n++) {
//            double t = Math.sqrt(n);
//            int m = (int) t;
//            for (int i = 2; i <= m; i++) {
//                int r = n % i;
//                if (r == 0) break;
//                if (i == m) {
//                    p = n;
//                    iCount++;
//                }
//
//            }
//            if (p == n) System.out.print(p + "\t");
//        }
//        System.out.println();
//        System.out.println(iCount);

        int iCount = 0;
        Loop:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue Loop;
                }
            }
            iCount++;
            System.out.println(i);
        }
        System.out.println("소수개수 : " + iCount);


    }
}
