package day0319;

import java.util.StringTokenizer;

public class Ex08_String {
    public static void main(String[] args) {
        System.out.println("** String 객체의 Method 공부하기 **");
        String str1 = "Have a Nice Day";
        String str2 = "apple";
        String str3 = "APPLE";

        System.out.println(str1.charAt(7));
        System.out.println(str1.charAt(0));
        System.out.println(str1.indexOf('a'));
        System.out.println(str1.indexOf('S')); //없을 시 -1
        System.out.println(str1.lastIndexOf('a'));
        System.out.println(str1.length());

        System.out.println(str2.concat("***")); //추가해서 반환
        System.out.println(str2+"***");

        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());


        ////문자열 비교(equals)
        System.out.println("apple".equals(str2));
        System.out.println("apple".equals(str3));
        System.out.println(str2.equals(str3));
        System.out.println(str2.equalsIgnoreCase(str3));//대소문자 상관 X

        System.out.println(str1.substring(7));
        System.out.println(str1.substring(7,10));

        System.out.println(str1.startsWith("Have")); //시작비교 플래그
        System.out.println(str1.startsWith("Nice"));

        System.out.println(str1.endsWith("Day"));
        System.out.println(str1.toLowerCase().endsWith("day"));


        System.out.println("apple".compareTo("append"));
        System.out.println("apple".compareTo("banana"));
        System.out.println("apple".compareTo("apple"));


        System.out.println(str2.repeat(3));
        System.out.println("* *".repeat(3));


        System.out.println(str1.replace('a','0'));
        System.out.println(str1.replace("Nice","Good"));


        String colors = "red, blue, green, yellow, pink";
        String []a1 = colors.split(", ");
        System.out.println(a1.length);

        for (int i = 0; i < 5; i++) {
            System.out.println(a1[i]);
        }


        //split 안될때
        StringTokenizer st = new StringTokenizer(colors, ", ");
        System.out.println("분리된 토큰 수 : " + st.countTokens());
        while (st.hasMoreTokens()){//토큰이 없을 경우 false
            System.out.println(st.nextToken());
        }

        String msg = "   Hel  lo   ";
        System.out.println(msg.length());
        System.out.println(msg.trim()); //양쪽 공백만 제거
        System.out.println(msg.replaceAll(" ", ""));


        //둘다 문자로 변환
        System.out.println(String.valueOf(3));
        System.out.println(3 + "");

    }
}
