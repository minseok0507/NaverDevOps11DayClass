package day0325;

class Animal{
    public void writeAnimal(){
        System.out.println("Animal parent");
    }

}

class Cat extends Animal{
    @Override
    public void writeAnimal() {
        super.writeAnimal();
        System.out.println("애옹! 애옹");
    }

    public void play(){
        System.out.println("애옹~");
    }
}

class Dog extends Animal{
    @Override
    public void writeAnimal() {
        super.writeAnimal();
        System.out.println("멍멍! 멍멍");
    }

    public void play(){
        System.out.println("멍멍~");
    }
}

public class Ex09_Inheri {
    public static void main(String[] args) {

        Cat c = new Cat();
        c.writeAnimal();
        c.play();

        Dog d = new Dog();
        d.writeAnimal();
        d.play();

        System.out.println("=".repeat(30));
        //부모로 선언, 자식으로 생성
        //오버라이드만 호출 가능
        //play() 호출 X
        Animal a = null;
        a = new Cat();
        a.writeAnimal();

        a = new Dog();
        a.writeAnimal();



    }
}
