package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStartWith {
    public static void main(String[] args) {
        String[] menbers = {"강호동", "한가인", "유재석", "이승민", "강하나", "손미나", "이영자", "박점정", "한지혜", "손창님"};
        Scanner sc = new Scanner(System.in);
        String searchName;


        while (true) {
            int iPus = 0;
            int iNum = 0;
            searchName = "";
            System.out.println("찾으시는 이름을 입력하시오.");
            searchName = sc.nextLine();

            if (searchName.equals("q") || searchName.equals("Q")) {
                System.out.println("이름 찾기 종료");
                break;
            }

            for (int i = 0; i < menbers.length; i++) {
                if (menbers[i].startsWith(searchName)) {
                    System.out.println((i + 1) + "번째 : " + menbers[i]);
                    iNum++;
                }
            }
            if (iNum == 0){
                System.out.println(searchName + "로 시작하는 이름이 없음");
            } else {
                System.out.println("총 " + iNum + "명 검색");
            }

        }
    }
}
