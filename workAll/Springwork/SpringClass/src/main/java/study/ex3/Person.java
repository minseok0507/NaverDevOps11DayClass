package study.ex3;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class Person {
    final private String name;
    private String phone;

//    public Person(String name) {
//        this.name = name;
//    }

//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
}
