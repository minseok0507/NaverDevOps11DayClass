package day0315;

public class Ex11_Oper {
    public static void main(String[] args) {
        //증감연산자
        //전치일 경우 1순위, 후치일 경우 마지막순위 (단항일 경우 상관X)
        int m = 5, n = 5;
        int a = 10, b = 10;
        m++;
        ++n;
        System.out.println("m = " + m); //6
        System.out.println("n = " + n); //6

        a += m++; //a = a + m, m = m + 1 //후치는 제일 마지막 계산
        System.out.println("a = " + a); //16
        System.out.println("m = " + m); //7

        b += ++n; // n = n + 1, b = b + n
        System.out.println("b = " + b); //17
        System.out.println("n = " + n); //7

        m = 5;
        System.out.println(m++);//5출력 후 증가

        n = 5;
        System.out.println(++n);//6출력

        System.out.println("m = " + m + "\nn = " + n);

    }

}
