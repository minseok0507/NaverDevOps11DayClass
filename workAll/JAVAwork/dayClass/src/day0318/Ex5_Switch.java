package day0318;

import java.util.Scanner;

public class Ex5_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iYear, iMonth, iDays;
        boolean bFlag;
        System.out.println("년도를 입력하세요.");
        iYear = sc.nextInt();
        if (iYear % 4 == 0 && iYear % 100 != 0 || iYear % 400 == 0) {
            bFlag = true;
            System.out.println(iYear + "년은 윤년입니다.");
        } else {
            bFlag = false;
            System.out.println(iYear + "년은 평년입니다.");
        }

        System.out.println("월을 입력하세요.");
        iMonth = sc.nextInt();
        if (iMonth < 1 || iMonth > 12) {
            System.out.println("잘못입력했습니다.");
        }

//        switch (iMonth) {
//            case 2:
//                iDays = bFlag ? 29 : 28;
////              iDays = bFlag == true ? 29 : 28;
//                break;
//            case 4, 6, 9, 11:
//                iDays = 30;
//                break;
//            default:
//                iDays = 31;
//        }

        if (iMonth == 2){
            iDays = bFlag ? 29 : 28;
        } else if (iMonth == 4 ||iMonth == 6 ||iMonth == 9 ||iMonth == 11) {
            iDays = 30;
        } else {
            iDays = 31;
        }

        System.out.println(iYear + "-" + iMonth + "-" + iDays + " 까지 있습니다.");

    }
}
