package day0318;

import java.awt.datatransfer.FlavorEvent;
import java.util.Scanner;

public class Ex8_Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sGoods;
        int iSu, iPrc, iDct;

        System.out.println("상품명이 무엇인가요.");
        sGoods = sc.nextLine();

        System.out.println("수량이 몇개인가요.");
        iSu = sc.nextInt();

        System.out.println("단가가 얼마인가요.");
        iPrc = sc.nextInt();

        System.out.println(sGoods + " " + iSu + "개의 총 금액 : " + iSu*iPrc);

        if (iSu >= 5){
            iDct = (int) ((iSu * iPrc) * 0.9);
            System.out.println("10% 할인입니다.");
            System.out.println("10% 할인된 금액 : " + iDct);
        }else {
            System.out.println("5개 이상 구매하셔야 10프로 할인됩니다.");
        }


    }
}
