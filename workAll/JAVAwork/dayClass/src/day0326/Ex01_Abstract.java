package day0326;

abstract class Animal {
    abstract public void sound();
    public void showTitle(){
        System.out.println("추상 클레스");
    }
}

class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("멍멍!");
    }
}

class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("냥냥!");
    }
}

class Chich extends Animal{
    @Override
    public void sound() {
        System.out.println("꼬꼬닭");
    }
}
public class Ex01_Abstract {
    public static void main(String[] args) {
        hello(new Cat());
        hello(new Dog());
        hello(new Chich());

    }

    public static void hello(Animal ani){
        ani.showTitle();
        ani.sound();
    }
}
