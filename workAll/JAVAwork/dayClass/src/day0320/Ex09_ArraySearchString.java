package day0320;

import java.util.Scanner;

public class Ex09_ArraySearchString {
    public static void main(String[] args) {
        String[] menbers = {"강호동", "한가인", "유재석", "이승민", "강하나", "손미나", "이영자", "박점정", "한지혜", "손창님"};
        String searchName;
        int iPus = 0;
        Scanner sc = new Scanner(System.in);


        while (true) {
            searchName = "";
            System.out.println("찾으시는 이름을 입력하시오.");
            searchName = sc.nextLine();


            if (searchName.equals("q") || searchName.equals("Q")) {
                System.out.println("이름 찾기 종료");
                break;
            }

            for (int i = 0; i < menbers.length; i++) {
                if (searchName.equals(menbers[i])) {
                    System.out.println((i + 1) + "번째 " + searchName + "씨가 있습니다.");
                    break;
                } else {
                    iPus++;
                }
            }

            if (iPus == menbers.length)
                System.out.println("찾으시는 이름이 없습니다.");
        }
    }
}
