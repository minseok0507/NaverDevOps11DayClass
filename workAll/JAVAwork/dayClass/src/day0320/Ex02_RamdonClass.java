package day0320;

import java.util.*;

public class Ex02_RamdonClass {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("** Random 클래스 난수 구하기");
        System.out.println("1. 0~9 난수");
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(10);
            System.out.printf("%4d", n);
        }
        System.out.println();

        System.out.println("2. 1 ~ 10 난수");
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(10) + 1;
            System.out.printf("%4d", n);
        }
        System.out.println();

        System.out.println("2. 1 ~ 100 난수");
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(100) + 1;
            System.out.printf("%4d", n);
        }
        System.out.println();

        System.out.println("2. A ~ Z 난수");
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(26) + 'A';
            System.out.printf("%4c", n);
        }
        System.out.println();

        System.out.println("2. a ~ z 난수");
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(26) + 'a';
            System.out.printf("%4c", n);
        }
        System.out.println();

        List<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(1);
        listWithDuplicates.add(2);
        listWithDuplicates.add(3);
        listWithDuplicates.add(2);
        listWithDuplicates.add(4);
        listWithDuplicates.add(3);

        List<Integer> listWithoutDuplicates = removeDuplicates(listWithDuplicates);

        System.out.println("Original list with duplicates: " + listWithDuplicates);
        System.out.println("List without duplicates: " + listWithoutDuplicates);


    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}
