package day0322;

import java.util.Scanner;

class Orange {

    private String name;
    private int age;

    private static String company = "SAMSUNG";

    //getter 메서드 : 멤버변수 값을 변환하는 메서드 (규식 getName, getAge)
    public String getName() {
        return this.name; //this 자신을 의미하는 인스턴스 변수
//        return name; 같은 구역안에 같은 변수가 없을 경우에만 this 생략가능
    }
    public int getAge() {
        return this.age;
    }

    public static String getCompany() {
        return company;
    }
    //외부로부터 값을 받아 멤버변수 값 변경

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Ex02_Object {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Orange org = new Orange();

        System.out.println("초기값 확인");
        System.out.println(org.getAge());
        System.out.println(org.getName());


        System.out.println("나이 값 변경");
        org.setAge(sc.nextInt());

        System.out.println("이름 값 변경");
        sc.nextLine();
        org.setName(sc.nextLine());
        System.out.println(org.getAge());
        System.out.println(org.getName());

        System.out.println(Orange.getCompany());

    }
}
