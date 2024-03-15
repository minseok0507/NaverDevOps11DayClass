package day0315;

import java.util.Scanner;

public class Ex8_Qut {
    public static void main(String[] args) {
        //이름 핸드폰 태어난 년도 입력받은 후
        int birthYear, age;
        String name, hp;
        Scanner sc = new Scanner(System.in);


        System.out.println("이름를 입력하시오.");
        name = sc.nextLine();
        System.out.println("핸드폰 번호를 입력하시오.");
        hp = sc.nextLine();
        System.out.println("태어난 년도를 입력하시오.");
        birthYear = Integer.parseInt(sc.nextLine());

        age = 2025 - birthYear;


        System.out.printf("이름 : %s\n번호 : %s\n태어난 년도 : %d년\n나이 : %d(K-나이)\n", name, hp, birthYear, age);

    }
}
