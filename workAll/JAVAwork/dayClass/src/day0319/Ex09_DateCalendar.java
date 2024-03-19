package day0319;

import java.util.Calendar;
import java.util.Date;

public class Ex09_DateCalendar {
    public static void main(String[] args) {

        Date date = new Date();
        int year = date.getYear(); //1900 빠진값
        int month = date.getMonth(); // 0~11
        int day = date.getDate();//제대로 나옴
        int week = date.getDay();//0일 1월 2화 ... 6토
        int hour = date.getHours();
        int min = date.getMinutes();
        int sec = date.getSeconds();

        System.out.println("Date 이용");
        System.out.println((year+1900) + "년 " + (month+1) + "월 " + day + "일 " +
                (week==0?"일":week==1?"월":week==2?"화":week==3?"수":week==4?"목":week==5?"금":"토") + "요일"
        );

        System.out.printf("%d시 %d분 %d초",hour,min, sec);

        System.out.println("=".repeat(30));

        System.out.println("Calender 이용");

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DATE);

        System.out.printf("%d년 %d월 %d일",year,month+1,day);

    }
}
