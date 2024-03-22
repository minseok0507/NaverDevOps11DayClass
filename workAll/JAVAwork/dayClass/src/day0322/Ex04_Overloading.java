package day0322;

class Oper {
    static public int sum(int a, int b) {
        return a + b;
    }
    static public double sum(double a, double b) {
        return a + b;
    }
    static public String sum(String a, String b) {
        return a + b;
    }

    //Variable Argument
    static public int hap(int ...n) {
        int a = 0;

        for (int i = 0; i < n.length; i++) {
            System.out.printf(n[i] + " ");
            a+=n[i];
        }
        System.out.println();

        return a;
    }
    public static void writeColor(String ...color){
        System.out.printf("총 %d개의 색 전달받음\n", color.length);
        for (int i = 0; i < color.length; i++) {
            System.out.println(i + " : " + color[i]);
        }
        System.out.println("=".repeat(10));
    }

}

public class Ex04_Overloading {
    public static void main(String[] args) {

        System.out.println(Oper.sum(1,1));
        System.out.println(Oper.sum(1.1,1.1));
        System.out.println(Oper.sum("1","1"));
        System.out.println(Oper.hap(5,1,4,6,5,2,5));
        Oper.writeColor("빨강","노랑","파랑","하양");
    }
}
