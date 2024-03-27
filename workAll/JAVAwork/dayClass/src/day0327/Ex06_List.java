package day0327;

import day0325.Phone;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Ex06_List {
    public static void main(String[] args) {
        List<String> list1 = new Vector<>();
        //List<String> list2 = new Vector<>(5);
        List<String> list2 = new Vector<>(5, 3); //할당량이 넘을 경우 3씩 증가 기본은 10부터 2배씩 증가

        System.out.println("list1 date count : " + list1.size());
        System.out.println("list1 할 count : " + ((Vector<String>) list1).capacity()); //하위 클래스여서 다운 클래스 필요
        System.out.println("list2 date count : " + list2.size());
        System.out.println("list2 할당 count : " + ((Vector<String>) list2).capacity());

        String[] str = {"red", "blue", "green", "white", "black", "red"};

        for (String r : str) {
            list1.add(r);
            list2.add(r);
        }

        System.out.println("=".repeat(60));

        System.out.println("list1 date count : " + list1.size());
        System.out.println("list1 할 count : " + ((Vector<String>) list1).capacity()); //하위 클래스여서 다운 클래스 필요
        System.out.println("list2 date count : " + list2.size());
        System.out.println("list2 할당 count : " + ((Vector<String>) list2).capacity());

        System.out.println("=".repeat(60));

        System.out.println("for (String s : list1)");
        for (String s : list1) {
            System.out.println(s);
        }


        System.out.println("=".repeat(60));

        System.out.println("list.get");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(i + ":" + list1.get(i) + "\t");
        }


        System.out.println("=".repeat(60));

        System.out.println("Itreator");
        Iterator<String> iter = list1.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }


        System.out.println("=".repeat(60));

        System.out.println("Object[] ob = list1.toArray();");
        Object[] ob = list1.toArray();
        for (Object s : ob){
            System.out.println((String) s);
        }
    }
}
