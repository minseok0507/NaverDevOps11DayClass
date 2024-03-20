package day0320;

import java.util.Scanner;

public class Ex06_Array {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 8, 9};

        System.out.println("출력");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int a : arr1) {
            System.out.printf("%4d", a);
        }
        System.out.println();
        int[] arr2;
        arr2 = new int[]{12, 54, 3, 1};
        System.out.println(arr2.length);

        for (int n : arr2) {
            System.out.printf("%4d", n);
        }

        System.out.println();

        String[] str1 = {"김영자", "이미자", "강호동", "이재성"};
        String[] str2;
        str2 = new String[]{"사과", "오랜지", "딸기", "수박", "참외"};


        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i]);
        }

        for (String s : str2) {
            System.out.println(s);
        }


    }
}
