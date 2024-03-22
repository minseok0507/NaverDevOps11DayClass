package day0322;


import java.util.Scanner;

/*
 * 생성자 특징
 * 클래스와 동일한 메서드로 만들어야됨
 * 리턴 타입이 없다
 * overloading 가능
 * 생성할 때 단 한번 호출
 * */
class Kiwi {
    String name, addr;

    Kiwi() {
        System.out.println("기본 생성자");
        name = "이미자";
        addr = "서울";
    }
    Kiwi(String name){
        this.name = name;
        this.addr = "서울";
    }

    Kiwi(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

    public void show(){
        System.out.println(name + "은 " + addr + "에 살고 있어요.");
    }
}

public class Ex08_Constructor {
    public static void main(String[] args) {
        Kiwi k1 = new Kiwi();
        k1.show();
        Kiwi k2 = new Kiwi("dlfma");
        k2.show();

        Kiwi k3 = new Kiwi("dlfma","tjnf");
        k3.show();
    }
}
