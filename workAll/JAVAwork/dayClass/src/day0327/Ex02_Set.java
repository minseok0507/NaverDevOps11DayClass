package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex02_Set {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("이청아");
        set1.add("유지태");
        set1.add("이미자");
        set1.add("한가인");
        set1.add("이청아");
        set1.add("강호동");

        System.out.println("set1 개수 : " + set1.size());

        for (String s : set1){
            System.out.println(s);
        }

        Iterator<String> iter = set1.iterator();
        System.out.println("\nIterator");
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
