package day0322;


import java.util.Scanner;

public class Ex07_ClassSawonArray {

    static public void inputSawonArray(Sawon[] sa) {
        String name;
        int stand;
        int money;
        for (int i = 0; i < sa.length; i++) {

            Scanner sc = new Scanner(System.in);

            System.out.println("사원" + (i + 1) + "의 이름을 입력하시오");
            name = sc.nextLine();

            System.out.println("사원" + (i + 1) + "의 기본금을 입력하시오");
            stand = Integer.parseInt(sc.nextLine());

            System.out.println("사원" + (i + 1) + "의 수당을 입력하시오");
            money = Integer.parseInt(sc.nextLine());

            sa[i] = new Sawon();

            sa[i].setSawon(name, stand, money);
        }
    }

    static public void outputSawonArray(Sawon[] sa) {
        System.out.println("\t\t[사원 급여 현황]\n");
        System.out.println("번호  사원명  기본금  수당  실수령액");
        System.out.println("-".repeat(40));
        for (int i = 0; i < sa.length; i++) {
            System.out.println((i + 1) + "\t" + sa[i].getName() + "\t\t" + sa[i].getStandard() + "\t" + sa[i].getMoney() + "\t" + sa[i].getNetPay());

        }
    }


    public static void main(String[] args) {

        Sawon[] sawon = null;
        int inwon;

        Scanner sc = new Scanner(System.in);


        System.out.println("직원 수?");
        inwon = Integer.parseInt(sc.nextLine());
        sawon = new Sawon[inwon];

        inputSawonArray(sawon);
        outputSawonArray(sawon);


    }


}
