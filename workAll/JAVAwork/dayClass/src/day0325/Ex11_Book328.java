package day0325;

abstract class Animal2{
    public void breathe(){
        System.out.println("숨을 쉽니다.");
    }

    public abstract void sound();
}

class Dog2 extends Animal2{
    @Override
    public void sound() {
        breathe();
        System.out.println("멍멍!");
    }
}

class Cat2 extends Animal2{
    @Override
    public void sound() {
        breathe();
        System.out.println("냥냥!");
    }
}

public class Ex11_Book328 {
    public static void main(String[] args) {
        Animal2 an = null;

        an = new Cat2();
        an.sound();
        an = new Dog2();
        an.sound();



        aniSound(new Cat2());
        aniSound(new Dog2());
    }

    public static void aniSound(Animal2 ani){
        ani.sound();
    }
}

