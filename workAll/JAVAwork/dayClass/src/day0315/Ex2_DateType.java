package day0315;

public class Ex2_DateType {
    public static void main(String[] args){
        byte a = 127;
        System.out.println(a);

        byte b = (byte) 200; //(byte) = cast연산자:강제로 형변환/값손실 발생
        System.out.println(b); //값손실이 발생할 경우 엉뚱한 값이 출력(<<2의 보수값)


        //실수 타입
        float f1 = 12.41353734F; //f를 붙어야 4바이트 float으로 저장
        double f2 = 123.12314123;

        System.out.println(f1); //8자리까지 정확히 나옴
        System.out.println(f2); //15자리까지 정확히 나옴


        //1글자 지정은 char, 문자열은 String(객체타입)
        char ch1 = 'A';//1글자만 가능해 ''로 해야됨
        char ch2 = '가';//2byte라 한글도 가능
        System.out.println(ch1);
        System.out.println(ch2);

        //문자열 지정하는 방법
        String str1 = new String("happy");
        String str2 = "hello";
        System.out.println(str1);
        System.out.println(str2);

        String str3 = "앙앙앙 난 네가 정말 좋아 도라에몽~";
        String str4 = "앙앙앙 난 네가 정말 좋아 도라에몽~" + "\n앙앙앙";

        System.out.println(str3);
        System.out.println(); //문자열 안에 \n = 한줄 밑으로
        System.out.println(str4);

        //텍스트 블록
        String str5 = """
                쌍따움표 안에 쓰면
                \\n안써도 밑으로 가능 
                """;
        System.out.println(str5);
    }
}