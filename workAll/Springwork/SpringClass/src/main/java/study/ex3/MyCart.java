package study.ex3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class MyCart {
    Person person;
    @NonNull
    private String name;
    @NonNull
    private int price;

//    public MyCart(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }

//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public void showInfo(){
        System.out.println("쇼핑한 사람의 이름 : " + person.getName());
        System.out.println("쇼핑한 사람의 번호 : " + person.getPhone());
        System.out.println("상품명 : " + name);
        System.out.println("가 격 : " + price);
    }
}
