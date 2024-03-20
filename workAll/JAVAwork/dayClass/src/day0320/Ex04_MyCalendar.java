package day0320;

import java.util.Date;
import java.util.Scanner;

public class Ex04_MyCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iYear, iMonth, iWeek, iEndDay;

        System.out.println("달력을 조회할 년도와 월을 입력하시오.");
        iYear = sc.nextInt();
        iMonth = sc.nextInt();

        if (iMonth < 1 || iMonth > 12) {
            System.out.println("잘못 입력했습니다.");
            return;
        }
        System.out.printf("%d년 %02d월 달력\n\n", iYear, iMonth);
        System.out.println("=".repeat(26));
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println("=".repeat(26));

        Date dDate = new Date(iYear - 1900, iMonth - 1, 1);
        iWeek = dDate.getDay();

        switch (iMonth) {
            case 2:
                iEndDay = iYear % 4 == 0 && iYear % 100 != 0 || iYear % 400 == 0 ? 29 : 28;
                break;
            case 4, 6, 9, 11:
                iEndDay = 30;
                break;
            default:
                iEndDay = 31;
        }
        System.out.print("\t".repeat(iWeek));
        for (int i = 0; i < iEndDay; i++) {
            System.out.printf("%d\t",i+1);
            iWeek++;
            if (iWeek == 7){
                System.out.println();
                iWeek = 0;
            }
        }

    }
}
