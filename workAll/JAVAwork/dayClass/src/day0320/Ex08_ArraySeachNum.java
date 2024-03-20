package day0320;

import javax.swing.*;
import java.util.Scanner;

public class Ex08_ArraySeachNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] date = {12, 24, 28, 3, 36, 4, 73, 43};
        int searchIndex, num;
        while (true) {
            searchIndex = -1;
            System.out.println("검색할 숫자 : ");
            num = sc.nextInt();
            if (num == 0) {
                System.out.println("검색종료");
                break;
            }
            for (int i = 0; i < date.length; i++) {
                if (num == date[i]) {
                    searchIndex = i;
                    break;
                }
            }
            if (searchIndex == -1)
                System.out.println(num + "은 데이터에 없음");
            else
                System.out.println(num + "은 " + (searchIndex+1) + "번째 있습니다.");
        }
    }
}
