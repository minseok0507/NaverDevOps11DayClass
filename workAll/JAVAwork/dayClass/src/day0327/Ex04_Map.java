package day0327;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex04_Map {
    public static void main(String[] args) {
        //Map: key value 쌍으로 저장
        //key는 set이므로 데이터중복x 비순차적
        Map<String, String> map1 = new HashMap<>();

        map1.put("name", "김태희");
        map1.put("age", "35세");
        map1.put("addr", "서울");
        map1.put("name", "한가인");//key가 잇을경우 덮어쓴다

        System.out.println("map1 count : " + map1.size());
        System.out.println("이름 : " + map1.get("name"));
        System.out.println("나이 : " + map1.get("age"));
        System.out.println("주소 : " + map1.get("addr"));
        System.out.println("hp : " + map1.get("hp"));//key없으면 null
        System.out.println("=".repeat(60));

        Set<String> keys = map1.keySet();
        for (String k : keys){
            String v = map1.get(k);
            System.out.println(k + " : " + v);
        }

    }
}
