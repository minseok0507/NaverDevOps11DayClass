package day0315;

public class Ex3_Output {
    public static void main(String[] args){
        int year = 2024;
        int month = 3;
        int day = 15;

        String msg = "Have a Nice Day!";

        char blood = 'A';
        double avg = 97.456;

        System.out.println("** 출력1 **");
        System.out.println("날짜 : " + year + "-" + month + "-" + day);
        System.out.print("혈액형 : " + blood + "형");
        System.out.println("\t평균 : " + avg);
        System.out.println("=============================");
        //printf 를 이용해서 출력해보자
        //변환기호를 이용해서 출력한다
        //정수 %d 실수%f 문자 %c 문자열&s
        System.out.printf("**%40s**\n\n", msg); //40칸의 우측 기준 출력
        System.out.printf("**%-40s**\n\n", msg); //40칸의 죄측 기준 출력
        System.out.printf("날짜:%d-%d-%d\n",year,month,day);
        System.out.printf("날짜:%2d-%2d-%2d\n",year,month,day);
        System.out.printf("날짜:%02d-%02d-%02d\n",year,month,day);
        System.out.printf("나의 혈액형은 %c형 입니다.\n", blood);
        System.out.printf("평균:%f\n", avg);
        System.out.printf("평균:%3.1f점\n", avg);
        System.out.printf("평균:%10.13f점\n", avg);
        System.out.printf("평균:%-10.3f점\n", avg);

    }
}
