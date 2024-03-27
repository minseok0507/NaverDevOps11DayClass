package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex01_Set {
    public static void main(String[] args) {
        /*
         * set특징
         * 중복데이터 x
         * 비순차적임
         * TreeSet 오름차순/HashSet 자기맘대로
         * */

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();

        set1.add(100);
        set1.add(78);
        set1.add(78);
        set1.add(100);
        set1.add(56);

        System.out.println("set1 개수 : " + set1.size());

        for (int n : set1){
            System.out.println(n);
        }


        set2.add(100);
        set2.add(78);
        set2.add(78);
        set2.add(100);
        set2.add(56);

        System.out.println("set2 개수 : " + set2.size());

        for (int n : set2){
            System.out.println(n);
        }

        Iterator<Integer> iter = set1.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println(set1.size());

    }
}
