package day0326;

import java.util.NavigableMap;

interface Apple{
    public void one();
}
interface Banana extends Apple{
    public void two();
}

class Orange implements Banana{
    @Override
    public void one() {
        System.out.println("one");
    }

    @Override
    public void two() {
        System.out.println("two");
    }

    public void three(){
        System.out.println("three");
    }
}

public class Ex05_Intetface {
    public static void main(String[] args) {
        Banana b = new Orange();
        b.one();
        b.two();
        ((Orange)b).three();
    }
}
