package day0325;

public class Ex10_Inheri {
    public static void showAnimal(Animal ani){
        ani.writeAnimal();

    }
    public static void main(String[] args) {
        showAnimal(new Cat());
        showAnimal(new Dog());

    }
}
