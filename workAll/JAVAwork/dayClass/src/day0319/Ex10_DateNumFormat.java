package day0319;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_DateNumFormat {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE"); //HH 24시간
        System.out.println(sdf1.format(date));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss EEEE"); //a 오전오후, hh 12시간
        System.out.println(sdf2.format(date));

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 "); //HH 24시간
        System.out.println(sdf3.format(date));

        int money = 567000;
        double aberage = 98.4131;

        NumberFormat nf1 = NumberFormat.getCurrencyInstance();
        System.out.println(nf1.format(money));

        System.out.println(NumberFormat.getInstance().format(money));
        System.out.println(NumberFormat.getCurrencyInstance().format(money));

        NumberFormat nf2 = NumberFormat.getInstance();
        nf2.setMaximumFractionDigits(1);
        System.out.println(nf2.format(aberage));


    }
}
